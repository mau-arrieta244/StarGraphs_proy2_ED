/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;

import java.util.ArrayList;
import java.util.Random;


public class Vertice {
    public int dato;
    boolean visitado;
    ArrayList<Vertice> aristas;
    //mau ... para ver que valores estan dentro de aristas que metimos
    ArrayList<Integer> valoresAristas;
    int peso;//peso

    // cosntructor
    public Vertice(int dato)
    {
        aristas = new ArrayList<Vertice>();
        valoresAristas = new ArrayList<Integer>();
        this.dato = dato;
        this.visitado = false;
    }

    public Vertice(int dato, int peso)
    {
        aristas = new ArrayList<Vertice>();
        this.dato = dato;
        this.visitado = false;
        this.peso = peso;
    }

    public void agregarArista (Vertice arista)
    {
        // si no está la arista para no repetir
        if (buscarArista(arista) == -1){
          aristas.add(new Vertice(arista.dato));
          valoresAristas.add(arista.dato);  
        }
            
    }
    
    public void agregarArista (Vertice arista, int peso)
    {
        // si no está la arista para no repetir
        if (buscarArista(arista) == -1)
            aristas.add(new Vertice(arista.dato, peso));
    }
    
    public void agregarAristaNaves (Vertice arista, int peso)
    //para poder darle add con cierto indice, que no se desordene output...
    //..cuando imprimimos grafo.vertices()
    {
        // si no está la arista para no repetir
        if (buscarArista(arista) == -1)
            aristas.add(arista.dato-1,new Vertice(arista.dato, peso));
        
        //si arista ya está en la lista le cambiamos peso
        else{
            Vertice ar = retornarArista(arista);
            
            ar.peso = peso;
            
        }
    }

    public int buscarArista(Vertice v)
    {
        for (int i = 0; i < aristas.size(); i++) {
            if (v.dato == aristas.get(i).dato)
                return i;
        }
        return -1;
    }
    
    public Vertice retornarArista(Vertice v)
    {
        for (int i = 0; i < aristas.size(); i++) {
            if (v.dato == aristas.get(i).dato)
                return aristas.get(i);
        }
        return null;
    }
}
