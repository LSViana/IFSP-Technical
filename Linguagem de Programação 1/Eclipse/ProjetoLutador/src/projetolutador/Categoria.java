package projetolutador;

import java.util.ArrayList;
import projetolutador.negocio.Lutador;

public class Categoria {

    private String tipo;

    public void setTipo(String tipo) {

        this.tipo = tipo;

        if (tipo.equals("Leve")) {

            ArrayList<Lutador> lutadoresLeve = new ArrayList();

        }
        if (tipo.equals("Pesado")) {

            ArrayList<Lutador> lutadoresPesado = new ArrayList();

        }
        if (tipo.equals("Medio")) {

            ArrayList<Lutador> lutadoresMedio = new ArrayList();

            Lutador medio = new Lutador();

        }

    }

    public String getTipo() {

        return tipo;

    }

}
