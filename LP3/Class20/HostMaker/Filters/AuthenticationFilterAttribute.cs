using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HostMaker.Controllers;
using HostMaker.Helpers;
using HostMaker.Repositories.Authentication;

namespace HostMaker.Filters
{
    public class AuthenticationFilterAttribute : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            var controllerName = filterContext.ActionDescriptor.ControllerDescriptor.ControllerName;
            var actionName = filterContext.ActionDescriptor.ActionName;

            if (controllerName != ControllerHelper.GetControllerName<HomeController>() &&
                    (
                        controllerName != ControllerHelper.GetControllerName<AuthenticationController>() &&
                        actionName != nameof(AuthenticationController.Login)
                    )
               )
            {
                if (UserManager.GetUserFromCookie() == null)
                {
                    // User is null, then, no authenticated, redirect to Home
                    filterContext.HttpContext.Response.Redirect($"/{ControllerHelper.GetControllerName<AuthenticationController>()}/{nameof(AuthenticationController.Login)}");
                }
            }
        }
    }
}