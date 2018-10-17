using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(CityMetadata))]
    public partial class City { }

    public class CityMetadata
    {
        [Required(ErrorMessage = "O nome é obrigatória")]
        [StringLength(50, ErrorMessage = "O nome pode ter no máximo 50 caracteres")]
        public string Name { get; set; }

        [Required(ErrorMessage = "A Unidade Federativa é obrigatória")]
        [StringLength(2, ErrorMessage = "A Unidade Federativa pode ter no máximo 2 caracteres")]
        public string FederativeUnit { get; set; }
    }
}