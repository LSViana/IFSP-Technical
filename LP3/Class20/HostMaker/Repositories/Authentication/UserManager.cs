using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using HostMaker.ViewModel;

namespace HostMaker.Repositories.Authentication
{
    public static class UserManager
    {
        public static bool Authenticate(Credentials credentials)
        {
            try
            {
                var db = new HostMakerEntities();
                var user = db.Users.FirstOrDefault(x => x.Login == credentials.Login && x.Password == credentials.Password);
                if (user is null)
                    return false;
                else
                {
                    CookieManager.CreateCookieAuth<User, int>(user.Id);
                    return true;
                }
            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
                return false;
            }
        }

        public static User GetUser(int id)
        {
            try
            {
                var db = new HostMakerEntities();
                var user = db.Users.FirstOrDefault(x => x.Id == id);
                return user;
            }
            catch (Exception)
            {
                return null;
            }
        }

        public static User GetUserFromCookie()
        {
            var cookieUser = HttpContext.Current.Request.Cookies[CookieManager.GetCookieName<User>()];

            if (cookieUser is null)
                return null;
            if (int.TryParse(cookieUser.Values[CookieManager.GetCookieValue<User>()], out var userId))
            {
                return GetUser(userId);
            }

            return null;
        }

    }
}