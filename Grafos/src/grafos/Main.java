/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;
import java.util.ArrayList;

/**
 *
 * @author dmora
 */
public class Main {
    
    //para que ventana pueda acceder al actual sin pasarselo como parametro
    //ArrayList<Grafo> grafos;
    public static ArrayList grafos = new ArrayList<Grafo>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        principal_gui ventana =  new principal_gui();
        ventana.setVisible(true);
        
        //para rellenar celdas con colores si tienen cierto valor
        TableColorCellRenderer render = new TableColorCellRenderer();
        ventana.matriz.setDefaultRenderer(Object.class,render);
        ventana.matriz1.setDefaultRenderer(Object.class,render);
        
        
        //Grafo a = new Grafo(ventana);
        //a.generarGrafoEnemigo();
        //a.imprimir3();
        
        
        
        Grafo g = new Grafo(ventana,ventana.matriz);
        grafos.add(g);
        System.out.println(grafos);
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
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(7));
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(8));
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(10));
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(3));
        g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(1));
        g.agregarAristaNave(g.buscarVertice(5), g.buscarVertice(2));
        g.agregarAristaNave(g.buscarVertice(6), g.buscarVertice(2));
        
        g.imprimir3();
        
        //g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(9));
        
        //g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(6));
        
        
        Grafo a = new Grafo(ventana,ventana.matriz1);
        grafos.add(a);
        
        
        System.out.println(grafos);
        a.agregarVertice(1);
        a.agregarVertice(2);
        a.agregarVertice(3);
        a.agregarVertice(4);
        a.agregarVertice(5);
        a.agregarVertice(6);
        a.agregarVertice(7);
        a.agregarVertice(8);
        a.agregarVertice(9);
        a.agregarVertice(10);
        
        a.agregarFuentePoder(2);
        a.agregarAristaNave(a.buscarVertice(4), a.buscarVertice(2));
        a.agregarAristaSoldado(a.buscarVertice(4), a.buscarVertice(9));
        a.agregarAristaSoldado(a.buscarVertice(4), a.buscarVertice(6));
        a.imprimir3();
        //g.atacarXY(2, 4,50);
        int abc = a.pesoAristas();
        a.pesoTotal = abc;
        
        //System.out.println("peso: "+g.pesoTotal);
        //g.profundidad();
        System.out.println("");

        //g.anchura(g.vertices.get(0));
        
        //Ataques
        //g.iniciarPoderes("clon", "teek");
        
    }
}
