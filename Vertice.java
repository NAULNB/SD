/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author Luan
 */
public class Vertice {
    private int nome; //maior que zero
    private int cor;  //maior que zero
    private String descricao;
    private double peso;
    private int incluir=0;
    private double k;
    

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        
        if(incluir==0){
        if (nome > 0){
            this.nome = nome;
            incluir ++;
        }                  
        else{
           System.out.println("Favor digitar um número positivo"); 
        }} else {
             
             System.out.println("Não é possível o nome do vértice.");
           
          }
        
        
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
          
        if (cor > 0){
            this.cor = cor;
        }                  
        else{
           System.out.println("Favor digitar um número positivo"); 
        }  
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        
        return peso;
    }

    public void setPeso(double peso) {
       
        if (peso > 0){
            this.peso = peso;
        }                  
        else{
           System.out.println("Favor digitar um número positivo"); 
        }  
    }
    
    
    
}
