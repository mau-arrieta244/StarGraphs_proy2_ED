/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

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
    //public static int vidaJugador = 100;
    //public static int vidaEnemigo = 100;
    
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
            
            //seteamos poder de nuestro ataque
            poderJugador = tribusEnemigas.get(tribuSeleccionada);
            //para no batallar contra nuestra misma tribu
            tribusEnemigas.remove(tribuSeleccionada);
        }
        
        //para rellenar celdas con colores si tienen cierto valor
        TableColorCellRenderer render = new TableColorCellRenderer();
        ventana.matriz.setDefaultRenderer(Object.class,render);
        
        //si queremos que no se rellene matriz con color (se mantenga escondida)
        //ventana.matriz1.setDefaultRenderer(Object.class,render);
        
        //mientras queden tribus enemigas por batallar
        while(tribusEnemigas.size()>=1){
            //siempre van a ser las mismas matrices, pero diferentes grafos en cada batalla
            //limpiamos matrices cada batalla
            
            //tal vez  ni sean necesarios
            //vidaEnemigo = 100; // reset babeyy
            //vidaJugador = 100;
            
            //ventana.labelVidaJugador.setText("100 %");
            //ventana.labelVidaEnemigo.setText("100 %");
        
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
            
            g.agregarVertice(11);
            g.agregarVertice(12);
            g.agregarVertice(13);
            g.agregarVertice(14);
            g.agregarVertice(15);
            g.agregarVertice(16);
            g.agregarVertice(17);
            g.agregarVertice(18);
            g.agregarVertice(19);
            g.agregarVertice(20);
            
            g.agregarVertice(21);
            g.agregarVertice(22);
            g.agregarVertice(23);
            g.agregarVertice(24);
            g.agregarVertice(25);
            g.agregarVertice(26);
            g.agregarVertice(27);
            g.agregarVertice(28);
            g.agregarVertice(29);
            g.agregarVertice(30);
            
            g.agregarFuentePoder(2);
        
            g.agregarAristaNave(g.buscarVertice(4), g.buscarVertice(2));
            g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(9));
            g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(7));
            g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(8));
            g.agregarAristaSoldado(g.buscarVertice(4), g.buscarVertice(10));
            g.agregarAristaNave(g.buscarVertice(5), g.buscarVertice(2));
            g.agregarAristaNave(g.buscarVertice(6), g.buscarVertice(2));
        
        
            int abcd = g.pesoAristas();
            g.pesoTotal = abcd;
            
            int porcentaje = abcd*100/(g.pesoTotal);
            ventana.labelVidaJugador.setText(String.valueOf(porcentaje)+" % aaaa yes");
            g.vidaGrafo = porcentaje; // estaba en 0, le ponemos valor correcto
            
            
            Grafo a = new Grafo(ventana,ventana.matriz1);
            //luego hay que sacarlo por que estamos atacando indice 1
            grafos.add(a);
            a.generarGrafoEnemigo();
            //a.esconderMatriz();
            //batallar con la primera
            int abc = a.pesoAristas();
            a.pesoTotal = abc;
            
            int porcentaje1 = abc*100/(a.pesoTotal);
            ventana.labelVidaEnemigo.setText(String.valueOf(porcentaje1)+" %");
            a.vidaGrafo = porcentaje1;
            //vidaEnemigo = porcentaje1; // reseteamos
            
            g.poderAtaque = poderJugador;
            Object myKey = tribusEnemigas.keySet().toArray()[0];
            a.poderAtaque = Integer.valueOf(tribusEnemigas.get(myKey));
            
            //mientras tribu enemiga tenga vida... espere
            while(a.vidaGrafo>0){
                Thread.sleep(2000);
            }
            System.out.println("se quedo sin vida!");
            JOptionPane.showMessageDialog(ventana,"Vencio tribu: "+myKey.toString(),"info",JOptionPane.INFORMATION_MESSAGE);
            //cuando se salga del while es que ya no tiene vida, seguimos con proxima tribu
            tribusEnemigas.remove(myKey); // sacamos tribu que ya vencimos y se repite este ciclo
            Thread.sleep(2000);
            a.limpiarMatriz();
            g.limpiarMatriz();
            
            //sacar ambos
            grafos.remove(g);
            grafos.remove(a);
            
        }
        
        //aca ya vencimos a todas las tribus
        JOptionPane.showMessageDialog(ventana,"Victoria! Has conquistado la Galaxia","info",JOptionPane.INFORMATION_MESSAGE);
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
