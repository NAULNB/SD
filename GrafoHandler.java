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

import java.util.*;
import org.apache.thrift.TException;

public class GrafoHandler implements Grafo.Iface { 
    
    private ArrayList<Vertice> vertices = new ArrayList();
    private ArrayList<Aresta> arestas = new ArrayList();
    /*
    tipo operaçoa
    1 - incluir
    2 - visualizar
    3 - editar
    4 - excluir
    */
    
    @Override
    public int GerVertice(int nome, int cor, String descricao, double peso, int tpOperacao) throws org.apache.thrift.TException{
        Vertice v = new Vertice();
             
        
        
        switch (tpOperacao){
                case 1:
                       v.setNome(nome);
                       v.setCor(cor);
                       v.setDescricao(descricao);
                       v.setPeso(peso);  
                       this.AddVertice(v);    
                break;
                case 2:             
                    System.out.println("nome: "+this.PesquisaVertice(nome).getNome());
                    System.out.println("descrição: "+this.PesquisaVertice(nome).getDescricao());
                    System.out.println("cor: "+this.PesquisaVertice(nome).getCor());
                    System.out.println("peso: "+this.PesquisaVertice(nome).getPeso());                   
                break;
                case 3:
                    v=this.PesquisaVertice(nome);

                    if (v !=null){
                       vertices.remove(v); 
                    }             
                    v.setNome(nome);
                    v.setCor(cor);
                    v.setDescricao(descricao);
                    v.setPeso(peso);  
                    this.AddVertice(v); 
                break;
                case 4:
                    this.DeletaVertice(nome);
                break;
        }            
        
        
     return 1;
    }

    @Override
    public int GerAresta(int v1, int v2, double peso, String direcao, String descricao, int tpOperacao) throws org.apache.thrift.TException {
        Aresta a = new Aresta();
        
        switch (tpOperacao){
           case 1:
                       a.setV1(v1);
                       a.setV2(v2);
                       a.setPeso(peso);  
                       a.setDirecao(direcao);
                       a.setDescricao(descricao);
                       this.AddAresta(a);    
                break;
                case 2:             
                    System.out.println("Vertice 1: "+this.PesquisaAresta(descricao).getV1());
                    System.out.println("Vertice 2: "+this.PesquisaAresta(descricao).getV2());
                    System.out.println("peso: "+this.PesquisaAresta(descricao).getPeso());  
                    System.out.println("direção: "+this.PesquisaAresta(descricao).getDirecao());
                    System.out.println("descrição: "+this.PesquisaAresta(descricao).getDescricao());                           
                break;
                case 3:
                    a=this.PesquisaAresta(descricao);

                    if (a !=null){
                       arestas.remove(a); 
                    }             
                    a.setV1(v1);
                    a.setV2(v2);
                    a.setPeso(peso);  
                    a.setDirecao(direcao);
                    a.setDescricao(descricao);
                    this.AddAresta(a);    
                break;
                case 4:
                    arestas.remove(a); 
                break;       
        } 
        
        return 1;
    }

    @Override
    public int ListaArestas(int vertice) throws org.apache.thrift.TException {
        for( Aresta a : arestas){
            if (a.getV1()==vertice || a.getV2()==vertice) {
                System.out.println("Vertice 1: "+a.getV1());
                System.out.println("Vertice 2: "+a.getV2());
                System.out.println("peso: "+a.getPeso());  
                System.out.println("direção: "+a.getDirecao());
                System.out.println("descrição: "+a.getDescricao());  
            }
        }      
        
    return 1;
    }

    @Override
    public int ListaVertices(String aresta) throws org.apache.thrift.TException {
        
    System.out.println("Vertice 1: "+this.PesquisaAresta(aresta).getV1());
    System.out.println("Vertice 2: "+this.PesquisaAresta(aresta).getV2());
    return 1; 
    }

    @Override
    public int ListarVizinhos(int vertice) throws org.apache.thrift.TException {
     for( Aresta a : arestas){
         if (a.getV1()==vertice || a.getV2()==vertice) {
                System.out.println("Vertice 1: "+a.getV1());
                System.out.println("Vertice 2: "+a.getV2());
                System.out.println("peso: "+a.getPeso());  
         }
     } 
        
     return 1;
    }

    @Override
    public int MenorCaminho(int origem, int destino) throws org.apache.thrift.TException {
        int ini=origem,fim=origem,qtd=0;
        int prim=0;
        double distTT=PesquisaVertice(origem).getPeso(),dist=0;
        ArrayList<Integer> caminho = new ArrayList();
       
        caminho.add(ini);
        
    while (fim != destino || qtd > arestas.size()){
     for( Aresta a : arestas){
            
         if ((a.getV1()==ini && a.getDirecao()=="1") ||(a.getV1()==ini && a.getDirecao()=="0")  ) {
             if (prim==0){ 
                       dist=a.getPeso();
                       prim++;
             }
             if (a.getPeso()<dist){
                 dist = a.getPeso();
                 fim = a.getV2();
             }   
         } else if( (a.getV2()==ini && a.getDirecao()=="2" )||(a.getV2()==ini && a.getDirecao()=="0" ) ) {
             if (prim==0){ 
                       dist=a.getPeso();
                       prim++;
             }
             if (a.getPeso()<dist){
                 dist = a.getPeso();
                 fim = a.getV1();
             }   
         }     
     } 
     
     ini = fim;
     distTT+= dist+PesquisaVertice(fim).getPeso();
     qtd++;
     caminho.add(ini);
    }   
     
    qtd=1;
    for( int i : caminho){
          System.out.println("Vertice "+qtd+" : "+ i);
          qtd++;
    }
    
    System.out.println("Distancia total percorrida: "+distTT);
        
      return 1;
    }
    
    
     public Vertice PesquisaVertice(int NomeVert){
        for( Vertice v : vertices){
            if (v.getNome()==NomeVert)
              return v;
        }
        System.out.println("Vertice não encontrado");
        return null;
    }
    
    public Aresta PesquisaAresta(String NomeAresta){
        for( Aresta a : arestas){
            if (a.getDescricao().contains(NomeAresta)){
                return a;
            }
        }
        System.out.println("Aresta não encontrado");
        return null;
    }
   

    private void setVertices(Vertice vertice) {
        
        int verificacao = 0 ;
        
        for( Vertice v : vertices){
            if (v.getNome()==vertice.getNome())
              verificacao=1;
        }
        
        if (verificacao==0 )
         this.vertices.add(vertice);
         else 
            System.out.println("Vértice já cadastrado.");
        
        
    }


    private void setArestas(Aresta aresta) {
        
        int verificacao=0;
        
         for( Vertice v : vertices){
            if (v.getNome()==aresta.getV1() || v.getNome()==aresta.getV2())
              verificacao++;
        }
        
        if (verificacao>=2 )
            this.arestas.add(aresta);
        else 
            System.out.println("Um dos vértices não existe.");

    }
    
    public void AddVertice(Vertice v){
       this.setVertices(v);
    }
    
    public void AddAresta(Aresta a){
       this.setArestas(a);
    }
    
    
    public void DeletaVertice(int V){
    
       int existe = 0 ;
       
       for( Vertice v : vertices){
            if (v.getNome()==V){
              existe++;
              vertices.remove(v);
            }
        }
       
     if (existe>0){   
       for( Aresta a : arestas){
            if (a.getV1()==V || a.getV2()==V){
                arestas.remove(a);
            }
        }
     }

    }
    
}
