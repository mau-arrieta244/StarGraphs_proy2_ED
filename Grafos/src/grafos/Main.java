/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;
import control.admTribus;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.Tribu;

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
    public static HashMap<String, Double> hashTribus = new HashMap<String, Double>();
    
    public static admTribus controlTribus = new admTribus(hashTribus);
    //nuestro poder de ataque, está acá para que ventan.atacarXY lo pueda acceder
    public static double poderJugador =0;
   
    //ambos empiezan con 100 de vida, se va a ir ajustando conforme pierdan vida
    //public static int vidaJugador = 100;
    //public static int vidaEnemigo = 100;
    
    //condicion de parada, se detendra cuando terminamos el juego totalmente
    //public static boolean condicion;
    
    public static void main(String[] args) throws InterruptedException {

        //-----------Creación de las tribus e enfrentamiento---------------------
        //Esta lista permite llevar dentro de un arraylist los nombres de todas las tribus
        //para asi ir descartando las que ya se usarion
        ArrayList<String> nombresTribus = controlTribus.crearArrayListNombres();
        //Se indica la tribu del jugador.
        Tribu tribuJugador = controlTribus.crearTribu("clon");
        Tribu tribuEnemigo;
        tribuEnemigo  = controlTribus.crearTribus(tribuJugador, nombresTribus);
        //Al comienzo se generan dos tribus, la del jugador y la de un enemigo.
        //Cuando se quiere hacer otro enfrentamiento, primero se debe actualizar
        //la fuerza y los poderes de la tribu del jugador y posteriormente, 
        //llamar a la funcion crearTribus2 para asi crear una nueva tribu enemiga
        //y llevar a cabo el enfrentamiento. Es importante cambiar /
        
        //Nota: falta ver como se va a evolucionar la tribu del jugador.
        //tribuEnemigo = controlTribus.crearTribus2(tribuJugador, tribuEnemigo, nombresTribus);
        
        //------------------------------------------------------------------------
        
        principal_gui ventana =  new principal_gui();
        ventana.setVisible(true);
        
        //mientras usuario no haya escogido tribu, espere
        while(tribuSeleccionada==""){
            Thread.sleep(2000);
        }
        
        if(hashTribus.containsKey(tribuSeleccionada)){
            
            //seteamos poder de nuestro ataque
            poderJugador = hashTribus.get(tribuSeleccionada);
            //para no batallar contra nuestra misma tribu
            hashTribus.remove(tribuSeleccionada);
        }
        
        //para rellenar celdas con colores si tienen cierto valor
        TableColorCellRenderer render = new TableColorCellRenderer();
        ventana.matriz.setDefaultRenderer(Object.class,render);
        
        //si queremos que no se rellene matriz con color (se mantenga escondida)
        //ventana.matriz1.setDefaultRenderer(Object.class,render);
        
        //mientras queden tribus enemigas por batallar
        while(hashTribus.size()>=1){
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
            /*
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
            */
            //mientras no se haya indicado si meter aristas manual o aleatorio.. espere
            while(g.ingresoDatos==false){
                Thread.sleep(2000);
            }
            //aca ya salio del while
            if(g.tipoIngreso.equals("A")){
                g.generarGrafoEnemigo();
            }
            else if(g.tipoIngreso.equals("M")){
                g.ingresoManual();
            }
            
            
            
            int abcd = g.pesoAristas();
            g.pesoTotal = abcd;
            
            int porcentaje = abcd*100/(g.pesoTotal);
            ventana.labelVidaJugador.setText(String.valueOf(porcentaje)+" % ");
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
            Object myKey = hashTribus.keySet().toArray()[0];
            a.poderAtaque = Double.valueOf(hashTribus.get(myKey));
            
            //mientras tribu enemiga tenga vida... espere
            while(a.vidaGrafo>0){
                Thread.sleep(2000);
            }
            System.out.println("se quedo sin vida!");
            JOptionPane.showMessageDialog(ventana,"Vencio tribu: "+myKey.toString(),"info",JOptionPane.INFORMATION_MESSAGE);
            //cuando se salga del while es que ya no tiene vida, seguimos con proxima tribu
            hashTribus.remove(myKey); // sacamos tribu que ya vencimos y se repite este ciclo
            Thread.sleep(2000);
            //g.vertices.clear();
            //a.vertices.clear();
            a.limpiarMatriz();
            g.limpiarMatriz();
            
            
            //sacar ambos
            grafos.remove(g);
            grafos.remove(a);
            
        }
        
        //aca ya vencimos a todas las tribus
        JOptionPane.showMessageDialog(ventana,"Victoria! Has conquistado la Galaxia","info",JOptionPane.INFORMATION_MESSAGE);
        
  
    }
}
