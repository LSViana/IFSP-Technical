using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(RoomKindMetadata))]
    public partial class RoomKind { }

    public class RoomKindMetadata
    {
        [Required(ErrorMessage = "A descrição é obrigatória")]
        [StringLength(30, ErrorMessage = "A descrição pode ter no máximo 30 caracteres")]
        public string Description { get; set; }

        [Required(ErrorMessage = "O custo diário é obrigatório")]
        public double DailyCost { get; set; }

        [Required(ErrorMessage = "A definição da presença ou não de café da manhã é obrigatório")]
        public bool Breakfast { get; set; }
    }
}