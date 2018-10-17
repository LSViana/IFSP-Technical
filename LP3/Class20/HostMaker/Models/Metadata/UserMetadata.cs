using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(UserMetadata))]
    public partial class User { }

    public class UserMetadata
    {
        [Required(ErrorMessage = "O nome é obrigatório")]
        [StringLength(30, ErrorMessage = "O nome pode ter no máximo 30 caracteres")]
        public string Name { get; set; }

        [Required(ErrorMessage = "O login é obrigatório")]
        [StringLength(20, ErrorMessage = "O login pode ter no máximo 20 caracteres")]
        public string Login { get; set; }

        [Required(ErrorMessage = "A senha é obrigatória")]
        [StringLength(10, ErrorMessage = "A senha pode ter no máximo 10 caracteres")]
        public string Password { get; set; }
    }
}