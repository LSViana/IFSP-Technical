using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class EstablishmentController : Controller
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            var instances = db.Establishments.ToList();
            return View(instances);
        }

        public ActionResult Create()
        {
            FillNavigationProperties();
            return View();
        }

        [HttpPost]
        public ActionResult Create(Establishment instance)
        {
            if (ModelState.IsValid)
            {
                db.Establishments.Add(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Edit(int id)
        {
            var instance = db.Establishments.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        private void FillNavigationProperties(Establishment instance = null)
        {
            ViewBag.IdCategory = new SelectList(db.Categories, nameof(Category.Id),
                nameof(Category.Description), instance?.IdCategory);
            ViewBag.IdCity = new SelectList(db.Cities, nameof(City.Id),
                nameof(City.Name), instance?.IdCity);
        }

        public ActionResult Details(int id)
        {
            return View(db.Establishments.Find(id));
        }

        [HttpPost]
        public ActionResult Edit(Establishment instance)
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
            var instance = db.Establishments.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public ActionResult DeletePost(int id)
        {
            try
            {
                Establishment instance = db.Establishments.Find(id);
                db.Establishments.Remove(instance);
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