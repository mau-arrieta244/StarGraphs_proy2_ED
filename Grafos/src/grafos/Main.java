/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dmora
 */
public class Main {
    
    //para que ventana pueda acceder al actual sin pasarselo como parametro
    //ArrayList<Grafo> grafos;
    public static ArrayList grafos = new ArrayList<Grafo>();
    
    //para colocar la tribu seleccionada (y con ello usar su golpe)
    //escogemos una y esta la tendremos hasta el final del juego
    public static String tribuSeleccionada= "";
    //tribus enemigas seran todas las otras (String,poder ataque)
    public static HashMap<String, Integer> tribusEnemigas = new HashMap<String, Integer>();
    
    //nuestro poder de ataque, está acá para que ventan.atacarXY lo pueda acceder
    public static int poderJugador =0;
   
    //ambos empiezan con 100 de vida, se va a ir ajustando conforme pierdan vida
    public static int vidaJugador = 100;
    public static int vidaEnemigo = 100;
    
    //condicion de parada, se detendra cuando terminamos el juego totalmente
    //public static boolean condicion;
    
    public static void main(String[] args) throws InterruptedException {
        
        //condicion = true;
        tribusEnemigas.put("Clones", 24);
        tribusEnemigas.put("Teek", 71);
        tribusEnemigas.put("Sullustanos", 131);
        
        principal_gui ventana =  new principal_gui();
        ventana.setVisible(true);
        
        //mientras usuario no haya escogido tribu, espere
        while(tribuSeleccionada==""){
            Thread.sleep(2000);
        }
        
        if(tribusEnemigas.containsKey(tribuSeleccionada)){
            
            poderJugador = tribusEnemigas.get(tribuSeleccionada);
            //para no batallar contra nuestra misma tribu
            tribusEnemigas.remove(tribuSeleccionada);
        }
        
        //para rellenar celdas con colores si tienen cierto valor
        TableColorCellRenderer render = new TableColorCellRenderer();
        ventana.matriz.setDefaultRenderer(Object.class,render);
        ventana.matriz1.setDefaultRenderer(Object.class,render);
        
        //mientras queden tribus enemigas por batallar
        while(tribusEnemigas!=null){
            //siempre van a ser los mismos dos grafos/matrices
            //los limpiamos luego de cada batalla
            
            Grafo g = new Grafo(ventana,ventana.matriz);
            grafos.add(g);
            //System.out.println(grafos);
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
        
        
            int abcd = g.pesoAristas();
            g.pesoTotal = abcd;
            
            Grafo a = new Grafo(ventana,ventana.matriz1);
            grafos.add(a);
            a.generarGrafoEnemigo();
            //batallar con la primera
            int abc = a.pesoAristas();
            a.pesoTotal = abc;
            
            
        }
        
        /*
        Grafo g = new Grafo(ventana,ventana.matriz);
        grafos.add(g);
        //System.out.println(grafos);
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
        int abcd = g.pesoAristas();
        g.pesoTotal = abcd;
        */
//-------------------------------------------------------------------------
//-------------------------------------------------------------------------

        /*
        Grafo a = new Grafo(ventana,ventana.matriz1);
        grafos.add(a);
        
        //System.out.println(grafos);
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
        */

        
        
    }
}
