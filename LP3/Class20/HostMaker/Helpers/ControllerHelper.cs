using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Helpers
{
    public static class ControllerHelper
    {
        public static string GetControllerName<TController>()
        {
            return typeof(TController).Name.Replace(nameof(Controller), "");
        }
    }
}