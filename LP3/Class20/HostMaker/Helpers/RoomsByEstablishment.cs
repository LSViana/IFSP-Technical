using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HostMaker.Helpers
{
    public class RoomsByEstablishment
    {
        public int IdEstablishment { get; set; }
        public string EstablishmentName { get; set; }
        public IEnumerable<Room> Rooms { get; set; }
    }
}