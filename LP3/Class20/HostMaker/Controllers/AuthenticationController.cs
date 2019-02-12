using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HostMaker.Helpers;
using HostMaker.Infrastructure;
using HostMaker.Repositories.Authentication;
using HostMaker.ViewModel;

namespace HostMaker.Controllers
{
    public class AuthenticationController : BaseController
    {
        [HttpGet]
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(Credentials credentials)
        {
            ViewBag.AuthenticationError = false;
            if (UserManager.Authenticate(credentials))
            {
                return RedirectToAction(nameof(HomeController.Index), ControllerHelper.GetControllerName<HomeController>());
            }
            else
            {
                ViewBag.AuthenticationError = true;
                return View();
            }
        }

        [HttpGet]
        public ActionResult Logout()
        {
            CookieManager.DeleteCookieAuth<User>();
            return RedirectToAction(nameof(HomeController.Index), ControllerHelper.GetControllerName<HomeController>());
        }
    }
}