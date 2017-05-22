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
public class Aresta {
    private int v1; //maior que zero
    private int v2; //maior que zero
    private double peso;
    private String direcao;
    private String descricao;
    private int incluir1=0;
    private int incluir2=0;

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        
        if (incluir1==0){
        if (v1 > 0){
            this.v1 = v1;
            incluir1++;
        }                  
        else{
           System.out.println("Favor digitar um número positivo"); 
        }  
         } 
        else {
           System.out.println("Não é possível alterar os vértices da aresta");
        }
        
    }
    
    
    
    
    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        
        if (incluir2==0){
        if (v2 > 0){
            this.v2 = v2;
            incluir2++;
        }                  
        else{
           System.out.println("Favor digitar um número positivo"); 
        }    
        } 
        else {
           System.out.println("Não é possível alterar os vértices da aresta");
        }
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

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
        // do primeiro para o segundo P
        // do segundo para o primeiro S
        // bidirecional               B
        
        if ("PSB".contains(direcao)){
           this.direcao = direcao;
        }
        else {
            System.out.println("Digite uma das opções a seguir");
            System.out.println("P - Da primeira para segunda aresta");
            System.out.println("S - Da segunda para primeira aresta");
            System.out.println("B - Para aresta birecional");
        }
            
            
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
