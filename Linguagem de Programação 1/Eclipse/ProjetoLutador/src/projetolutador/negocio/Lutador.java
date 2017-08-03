package projetolutador.negocio;

import projetolutador.Cartel;

public class Lutador {

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private int id;
    private String nome;
    private String apelido;
    private double peso;

    private double altura;
    private int idade;
    private String categoria;

    //private Categoria categoria;
    //método construtor
    public void Lutador(int id, String nome, String apelido,
            double peso, Cartel cartel, double altura, int idade) {
//Categoria categoria/* 

        this.setAltura(altura);
        this.setId(id);
        this.setNome(nome);
        this.setApelido(apelido);
        this.setPeso(peso);
        this.setIdade(idade);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 65 || peso > 100) {
            System.out.println("não há categoria ");
        } else {
            this.peso = peso;
            if (this.peso < 70) {
                setCategoria("Peso Leve");
            }
 
            if (this.peso > 70 & this.peso < 80) {

                setCategoria("Peso Medio");

            } else {

                setCategoria("Peso Pesado");

            }

        }

    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        String texto;
        texto = getNome() + ";" + String.valueOf(getId()) + ";" + getApelido() + ";" + getCategoria();
        return texto;
    }

}
