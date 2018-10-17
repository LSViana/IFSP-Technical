using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class RoomController : Controller
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            var instances = db.Rooms.ToList();
            return View(instances);
        }

        public ActionResult Create()
        {
            FillNavigationProperties();
            return View();
        }

        [HttpPost]
        public ActionResult Create(Room instance)
        {
            if (ModelState.IsValid)
            {
                db.Rooms.Add(instance);
                db.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            FillNavigationProperties(instance);
            return View(instance);
        }

        public ActionResult Edit(int id)
        {
            var instance = db.Rooms.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        private void FillNavigationProperties(Room instance = null)
        {
            ViewBag.IdEstablishment = new SelectList(db.Establishments, nameof(Establishment.Id),
                nameof(Establishment.Name), instance?.IdEstablishment);
            ViewBag.IdRoomKind = new SelectList(db.RoomKinds, nameof(RoomKind.Id),
                nameof(RoomKind.Description), instance?.IdRoomKind);
        }

        public ActionResult Details(int id)
        {
            return View(db.Rooms.Find(id));
        }

        [HttpPost]
        public ActionResult Edit(Room instance)
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
            var instance = db.Rooms.Find(id);
            FillNavigationProperties(instance);
            return View(instance);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public ActionResult DeletePost(int id)
        {
            try
            {
                Room instance = db.Rooms.Find(id);
                db.Rooms.Remove(instance);
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