using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HostMaker.Helpers;
using HostMaker.Infrastructure;

namespace HostMaker.Controllers
{
    public class QueryController : BaseController
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult RoomKind()
        {
            return View(db.RoomKinds.AsEnumerable());
        }

        public ActionResult RoomKindQuery(int? id)
        {
            if (id is null)
                return RedirectToAction(nameof(RoomKind));
            //
            var roomsArray = db.Rooms
                .Include(nameof(Room.Establishment))
                .Include(nameof(Room.RoomKind))
                .ToArray();
            var roomsToView = roomsArray
                .Where(x => x.IdRoomKind == id)
                .OrderBy(x => x.Id)
                .GroupBy(x => x.IdEstablishment)
                .Select(x => new RoomsByEstablishment()
                {
                    IdEstablishment = x.Key,
                    EstablishmentName = x.ElementAt(0).Establishment.Name,
                    Rooms = x.AsEnumerable()
                })
                .OrderBy(x => x.EstablishmentName);
            return View(roomsToView);
        }

        public ActionResult RoomDetails()
        {
            var rooms = db.Rooms
                .Include(nameof(Room.RoomKind));
            return View(rooms);
        }
    }
}