package projetolutador;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import projetolutador.negocio.Lutador;
import projetolutador.tela.CadastrarLutador;

public class ProjetoLutador {

    public static void main(String args[]) {

        Lutador l = new Lutador();
        l.setPeso(64.99999999999999);
        
        System.out.println(l.getPeso());

    }

}
