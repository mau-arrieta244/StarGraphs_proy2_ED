/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos.GrafoMatriz;

/**
 *
 * @author dmora
 */
public class Main {
        public static void main(String[] args) {

        GrafoMatriz g = new GrafoMatriz(30);

        g.agregarVertice(10);
        g.agregarVertice(20);
        g.agregarVertice(30);
        g.agregarVertice(40);
        g.agregarVertice(50);
        g.agregarVertice(60);
//dijkstra
        g.agregarArista(g.vertices[0], g.vertices[1],7);
        g.agregarArista(g.vertices[1], g.vertices[0],7);
        g.agregarArista(g.vertices[0], g.vertices[2],9);
        g.agregarArista(g.vertices[2], g.vertices[0],9);
        g.agregarArista(g.vertices[0], g.vertices[5],14);
        g.agregarArista(g.vertices[5], g.vertices[0],14);
        g.agregarArista(g.vertices[1], g.vertices[2],10);
        g.agregarArista(g.vertices[2], g.vertices[1],10);
        g.agregarArista(g.vertices[1], g.vertices[3],15);
        g.agregarArista(g.vertices[3], g.vertices[1],15);
        g.agregarArista(g.vertices[2], g.vertices[3],11);
        g.agregarArista(g.vertices[3], g.vertices[2],11);
        g.agregarArista(g.vertices[2], g.vertices[5],2);
        g.agregarArista(g.vertices[5], g.vertices[2],2);
        g.agregarArista(g.vertices[3], g.vertices[4],6);
        g.agregarArista(g.vertices[4], g.vertices[3],6);
        g.agregarArista(g.vertices[5], g.vertices[4],9);
        g.agregarArista(g.vertices[4], g.vertices[5],9);


//
        System.out.println("");
            //g.borrarArista(g.vertices[2]);
            //g.matriz[0][1] = 6;
        g.imprimir();
            //System.out.println("");
            //g.dijkstra(g.vertices[0]);
            //System.out.println("");
  


    }

}
