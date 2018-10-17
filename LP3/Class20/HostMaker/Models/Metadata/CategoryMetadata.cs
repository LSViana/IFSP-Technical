using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(CategoryMetadata))]
    public partial class Category { }

    public class CategoryMetadata
    {
        [Required(ErrorMessage = "A descrição é obrigatória")]
        [StringLength(40, ErrorMessage = "A descrição pode ter no máximo 40 caracteres")]
        public string Description { get; set; }
    }
}