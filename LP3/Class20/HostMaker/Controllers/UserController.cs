using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class UserController : Controller
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            var instances = db.Users.ToList();
            return View(instances);
        }

        public ActionResult Create()
        {
            FillNavigationProperties();
            return View();
        }

        [HttpPost]
        public ActionResult Create(User instance)
        {
            if (ModelState.IsValid)
            {
                db.Users.Add(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Edit(int id)
        {
            var instance = db.Users.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        private void FillNavigationProperties(User instance = null)
        {
        }

        public ActionResult Details(int id)
        {
            return View(db.Users.Find(id));
        }

        [HttpPost]
        public ActionResult Edit(User instance)
        {
            if (ModelState.IsValid)
            {
                db.Entry(instance).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Delete(int id)
        {
            var instance = db.Users.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public ActionResult DeletePost(int id)
        {
            try
            {
                User instance = db.Users.Find(id);
                db.Users.Remove(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch (Exception)
            {
                return RedirectToAction(nameof(DeleteError));
            }
        }

        public ActionResult DeleteError()
        {
            return View();
        }
    }
}