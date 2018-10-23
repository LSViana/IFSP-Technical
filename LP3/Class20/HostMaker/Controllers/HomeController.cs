using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Controllers
{
    public class HomeController : Controller
    {
        private HostMakerEntities db = new HostMakerEntities();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Search(int? idCity, int? idCategory)
        {
            var performTheSearch = idCity != null && idCategory != null;
            ViewBag.DidSearch = performTheSearch;
            // Filling the drop downs
            ViewBag.IdCategory = new SelectList(db.Categories, nameof(Category.Id), nameof(Category.Description));
            ViewBag.IdCity = new SelectList(db.Cities, nameof(City.Id), nameof(City.Name));
            // Data to be listed
            IEnumerable<Establishment> establishments = new Establishment[0];
            //
            if (performTheSearch)
            {
                establishments = db.Establishments.Where(a => a.IdCategory == idCategory.Value && a.IdCity == idCity.Value);
            }
            return View(establishments);
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}