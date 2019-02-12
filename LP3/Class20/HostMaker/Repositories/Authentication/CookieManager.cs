using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HostMaker.Repositories.Authentication
{
    public static class CookieManager
    {
        public static void CreateCookieAuth<TEntity, TKey>(TKey id)
        {
            var httpCookie = new HttpCookie(GetCookieName<TEntity>());
            httpCookie.Values[GetCookieValue<TEntity>()] = id.ToString();
            httpCookie.Expires = DateTime.Now.AddDays(1);
            HttpContext.Current.Response.Cookies.Add(httpCookie);
        }

        public static void DeleteCookieAuth<TEntity>()
        {
            var httpCookie = new HttpCookie(GetCookieName<TEntity>());
            // Making it expire now causes its deletion by client browser
            httpCookie.Expires = DateTime.Now;
            HttpContext.Current.Response.Cookies.Add(httpCookie);
        }

        public static string GetCookieValue<TEntity>()
        {
            return $"Key{typeof(TEntity).Name}";
        }

        public static string GetCookieName<TEntity>()
        {
            return $"Cookie{typeof(TEntity).Name}";
        }
    }
}