using HostMaker.Infrastructure;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class RoomKindController : BaseController
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            var instances = db.RoomKinds.ToList();
            return View(instances);
        }

        public ActionResult Create()
        {
            FillNavigationProperties();
            return View();
        }

        [HttpPost]
        public ActionResult Create(RoomKind instance)
        {
            if (ModelState.IsValid)
            {
                db.RoomKinds.Add(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Edit(int id)
        {
            var instance = db.RoomKinds.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        private void FillNavigationProperties(RoomKind instance = null)
        {
        }

        public ActionResult Details(int id)
        {
            return View(db.RoomKinds.Find(id));
        }

        [HttpPost]
        public ActionResult Edit(RoomKind instance)
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
            var instance = db.RoomKinds.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public ActionResult DeletePost(int id)
        {
            try
            {
                RoomKind instance = db.RoomKinds.Find(id);
                db.RoomKinds.Remove(instance);
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