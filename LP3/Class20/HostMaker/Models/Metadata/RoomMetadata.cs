using System.ComponentModel.DataAnnotations;

namespace HostMaker.Models.Metadata
{
    [MetadataType(typeof(RoomMetadata))]
    public partial class Room { }

    public class RoomMetadata
    {
        [Required(ErrorMessage = "O estabelecimento é obrigatório")]
        public int IdEstablishment { get; set; }

        [Required(ErrorMessage = "O número do quarto é obrigatório")]
        public int Id { get; set; }

        [Required(ErrorMessage = "O tipo de quarto é obrigatório")]
        public int IdRoomKind { get; set; }

        [Required(ErrorMessage = "A definição de disponibilidade é obrigatória")]
        public bool Available { get; set; }
    }
}