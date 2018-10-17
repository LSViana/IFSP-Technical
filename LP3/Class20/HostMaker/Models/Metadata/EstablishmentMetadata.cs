using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(EstablishmentMetadata))]
    public partial class Establishment { }

    public class EstablishmentMetadata
    {
        [Required(ErrorMessage = "A cidade é obrigatória")]
        public int IdCity { get; set; }

        [Required(ErrorMessage = "A categoria é obrigatória")]
        public int IdCategory { get; set; }

        [Required(ErrorMessage = "O nome é obrigatório")]
        [StringLength(30, ErrorMessage = "O nome pode ter no máximo 30 caracteres")]
        public string Name { get; set; }

        [Required(ErrorMessage = "O endereço é obrigatório")]
        [StringLength(50, ErrorMessage = "O endereço pode ter no máximo 50 caracteres")]
        public string Address { get; set; }

        [Required(ErrorMessage = "O telefone é obrigatório")]
        [StringLength(11, ErrorMessage = "O telefone pode ter no máximo 11 caracteres")]
        public string Telephone { get; set; }

        [Required(ErrorMessage = "O site é obrigatório")]
        [StringLength(40, ErrorMessage = "O site pode ter no máximo 40 caracteres")]
        public string Site { get; set; }
    }
}