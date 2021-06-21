/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;

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
        
        
        Grafo a = new Grafo(ventana);
        a.generarGrafoEnemigo();
        
        /*
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
        
        g.agregarFuentePoder(2);
        g.agregarAristaNave(g.buscarVertice(4), g.buscarVertice(2));
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(9));
        
        g.imprimir3();
        */
        
        
        
        System.out.println("");
        //g.profundidad();
        System.out.println("");

        //g.anchura(g.vertices.get(0));
        
        //Ataques
        //g.iniciarPoderes("clon", "teek");
        
    }
}
