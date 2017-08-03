/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolutador;

    public class Cartel {

   
            private int vitorias;
            private int derrotas;
            private int empates;
            
            public void Cartel(int vitorias,int derrotas,int empates){
            
            this.setDerrotas(derrotas);
            this.setEmpates(empates);
            this.setVitorias(vitorias);
            
            
            
            }
            
            
            
            


                        /**
                * @return the vitorias
                */
               public int getVitorias() {
                   return vitorias;
               }

               /**
                * @param vitorias the vitorias to set
                */
               public void setVitorias(int vitorias) {
                   this.vitorias = vitorias;
               }

               /**
                * @return the derrotas
                */
               public int getDerrotas() {
                   return derrotas;
               }

               /**
                * @param derrotas the derrotas to set
                */
               public void setDerrotas(int derrotas) {
                   this.derrotas = derrotas;
               }

               /**
                * @return the empates
                */
               public int getEmpates() {
                   return empates;
               }

               /**
                * @param empates the empates to set
                */
               public void setEmpates(int empates) {
                   this.empates = empates;
               }
    }
