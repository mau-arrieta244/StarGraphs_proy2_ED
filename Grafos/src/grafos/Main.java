/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;

import java.util.Random;

/**
 *
 * @author dmora
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        principal_gui ventana =  new principal_gui();
        ventana.setVisible(true);
        
        //para rellenar celdas con colores si tienen cierto valor
        TableColorCellRenderer render = new TableColorCellRenderer();
        ventana.matriz.setDefaultRenderer(Object.class,render);
        
        Grafo g = new Grafo(ventana);
        
        
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);
        g.agregarVertice(9);
        g.agregarVertice(10);
        
        
        g.agregarArista(g.buscarVertice(3), g.buscarVertice(4));
        g.agregarArista(g.buscarVertice(4), g.buscarVertice(5));
        g.agregarAristaNave(g.buscarVertice(1), g.buscarVertice(3));
        g.agregarArista(g.buscarVertice(2), g.buscarVertice(9));
        g.agregarAristaNave(g.buscarVertice(8), g.buscarVertice(6));


        
        
        g.imprimir();
        System.out.println("");
        //g.profundidad();
        System.out.println("");

        //g.anchura(g.vertices.get(0));

    }

}
