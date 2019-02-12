using HostMaker.Infrastructure;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class CityController : BaseController
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            var instances = db.Cities.ToList();
            return View(instances);
        }

        public ActionResult Create()
        {
            FillNavigationProperties();
            return View();
        }

        [HttpPost]
        public ActionResult Create(City instance)
        {
            if (ModelState.IsValid)
            {
                db.Cities.Add(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Edit(int id)
        {
            var instance = db.Cities.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        private void FillNavigationProperties(City instance = null)
        {
        }

        public ActionResult Details(int id)
        {
            return View(db.Cities.Find(id));
        }

        [HttpPost]
        public ActionResult Edit(City instance)
        {
            if (ModelState.IsValid)
            {
                db.Entry(instance).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties();
            return View(instance);
        }

        public ActionResult Delete(int id)
        {
            var instance = db.Cities.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public ActionResult DeletePost(int id)
        {
            try
            {
                City instance = db.Cities.Find(id);
                db.Cities.Remove(instance);
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