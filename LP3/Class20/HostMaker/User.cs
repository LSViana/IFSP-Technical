//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System.ComponentModel.DataAnnotations;

namespace HostMaker
{
    using System;
    using System.Collections.Generic;
    
    public partial class User
    {
        [Display(Name = "ID")]
        public int Id { get; set; }
        [Display(Name = "Nome")]
        public string Name { get; set; }
        [Display(Name = "Login")]
        public string Login { get; set; }
        [Display(Name = "Senha")]
        public string Password { get; set; }
    }
}
