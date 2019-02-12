using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HostMaker.Filters;
using HostMaker.Repositories.Authentication;

namespace HostMaker.Infrastructure
{
    [AuthenticationFilter]
    public class BaseController : Controller
    {
        protected override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            base.OnActionExecuting(filterContext);

            #region Logout Button

            var user = UserManager.GetUserFromCookie();
            var authenticated = false;
            if (user != null)
            {
                authenticated = true;
            }
            ViewBag.Authenticated = authenticated;

            #endregion
        }
    }
}