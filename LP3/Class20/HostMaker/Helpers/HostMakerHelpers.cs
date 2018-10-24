using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HostMaker.Helpers
{
    public static class HostMakerHelpers
    {
        public static MvcHtmlString ShowAdvertisement(this HtmlHelper helper)
        {
            return new MvcHtmlString("HostMaker é a melhor aplicação para hotéis e estabelecimentos de hospedagem");
        }

        public static MvcHtmlString ShowFamousPartnerImages(this HtmlHelper helper)
        {
            return new MvcHtmlString("<div class=\"flex-container\">" +
                                     "<div>" +
                                     "<img src=\"/Images/ibis.png\" class=\"partner-image\" />" +
                                     "</div>" +
                                     "<div>" +
                                     "<img src=\"/Images/able-hotels.jpg\" class=\"partner-image\" />" +
                                     "</div>" +
                                     "<div>" +
                                     "<img src=\"/Images/royal-tulip.jpg\" class=\"partner-image\" />" +
                                     "</div>" +
                                     "</div>");
        }
    }
}