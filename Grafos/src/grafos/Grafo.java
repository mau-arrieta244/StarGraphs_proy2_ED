

package grafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JTable;
/**
 *
 * @author dmora
 */
public class Grafo {
    //para usar al calcular % de vida
    int pesoTotal;
    
    //para calcular su vida restante ej: 100 , 73 , 24, 0 (el propio numero)
    int vidaGrafo;
    
    //recibe ventana
    principal_gui ventana;
    
    //tal vez en vez de recibir ventana, recibe matriz por modificar
    //asi podemos hacer dos grafos (jugador y enemigo) y pasarles misma ventana pero diferente matriz
    JTable matriz;
    
    //tendra arraylist para no repetir aristas entre soldados y naves
    ArrayList<Integer> verticesNaves;
    
    //arraylist para solo poder poner soldados en naves (no a la deriva)
    ArrayList<Integer> verticesNaves2;
    
    //tendra arraylist para no repetir aristas entre naves y soldados
    //(no se podra agregar nave si ya hay soldado en ese origen/destino)
    ArrayList<Integer> verticesSoldados;
    
    //Para cumplir que naves se coloquen en fuentes de poder
    //(solo si origen/destino nave esta en esta lista, la deja colocarse)
    ArrayList<Integer> verticesFuentesPoder;
    
    //profe
    ArrayList<Vertice> vertices;
    
    //para pasarle poder de ataque a atacarXY
    double poderAtaque;
    
    

    public Grafo(principal_gui pVentana,JTable pMatriz)
    {
        
        vertices = new ArrayList<Vertice>();
        verticesNaves = new ArrayList<Integer>();
        verticesSoldados = new ArrayList<Integer>();
        verticesFuentesPoder = new ArrayList<Integer>();
        ventana = pVentana;
        matriz = pMatriz;
        
        verticesNaves2 = new ArrayList<Integer>();
        poderAtaque = 0;
        
        vidaGrafo=0;
    }
    public void imprimir2(){
        for (Vertice vert : vertices){
            System.out.println("\n lista ------- ");
            System.out.println(vert.aristas);
            System.out.println(" ------- \n");
            
        }
    }
    // agrega a la lista
    public void agregarVertice(int valor)
    {
        vertices.add(new Vertice(valor));
    }
    
    //peso total de todas las aristas
    public int pesoAristas(){
        int peso = 0;
        for (Vertice v : vertices){
            for(Vertice arista : v.aristas){
                peso+=arista.peso;
            }
        }
        return peso;
    }

    // agrega las aristas
    public void agregarArista(Vertice origen, Vertice destino)
    {
        if (origen != null && destino != null){
          origen.agregarArista(destino);
          //si quiero que sea no-dirigido:
          destino.agregarArista(origen); 
          
          //estos estan ahorita con "." por default, los podemos cambiar
          //ventana.matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          //ventana.matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
          matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
        }
            
    }
    
    //limpia la matriz  y deja vertices del grafo en blanco
    public void limpiarMatriz()
    {
        for(Vertice v : this.vertices){
            int total = this.vertices.size();
            while(total>0){
              matriz.getModel().setValueAt("", v.dato-1, total);  
              total--;
            }
            //eliminar todas las aristas (limpiar los vertices)
            for (Iterator<Vertice> iterator = v.aristas.iterator(); iterator.hasNext();) 
            {
                Vertice arista = iterator.next();
                iterator.remove();
                //v.aristas.remove(arista);
            }
        }
        System.out.println("\n ----- grafo limpio : -----------------");
        this.imprimir3();
        System.out.println("\n --------------------------------------\n");
        
        
          
        
            
    }
    
    
    //limpia la matriz del enemigo en GUI pero deja los vertices como están
    public void esconderMatriz()
    {
        for(Vertice v : this.vertices){
            int total = this.vertices.size();
            while(total>0){
              matriz.getModel().setValueAt("", v.dato-1, total);  
              total--;
            }
            
        }
        System.out.println("\n ----- grafo limpio : -----------------");
        this.imprimir3();
        System.out.println("\n --------------------------------------\n");
        
        
          
        
            
    }
    /*
    public int vidaActual(){
       int inicial = 100;
       
    }
    */
    public void atacarXY(int x,int y,double golpe){
        
        //obtiene lo que haya en GUI en ese punto X,Y
        //String valor = ventana.matriz.getModel().getValueAt(x-1, y).toString();
        
        //si hay arista en ese (X,Y)
        if(matriz.getModel().getValueAt(x-1, y)!=null){
           String valor = matriz.getModel().getValueAt(x-1, y).toString();
            //si el valor es soldado
            if(valor.equals("..")){
                ventana.bitacora.append("\nArista Soldado");
                atacarXYSoldado(x,y,golpe);
            }
            //si el valor es una nave
            else if(valor.equals(",")){
                ventana.bitacora.append("\nArista Nave");
                atacarXYNave(x,y,golpe);
            
            }
            //que hacemos cuando ataque va a arista fuente de poder? 
        }
        else{
           ventana.bitacora.append("\nSin daños (arista vacia)"); 
        }
        
        
        
        
        
        
    }
    public void atacarXYSoldado(int x,int y,double golpe){
        
        for (Vertice v : vertices){
            if(v.dato == x){
                //ocupamos iterador para quitar arista de arrayList mientras lo recorremos
                for (Iterator<Vertice> iterator = v.aristas.iterator(); iterator.hasNext();) {
                Vertice arista = iterator.next();
                if(arista.dato == y){
                        System.out.println("\n --- X antes ---");
                        System.out.println(arista.peso);
                        ventana.bitacora.append("\nVida antes: "+String.valueOf(arista.peso));
                        System.out.println(" -----------\n");
                        if(arista.peso>0){
                          arista.peso-=golpe; 
                          ventana.bitacora.append("\nVida actual: "+String.valueOf(arista.peso));
                          //si llegó a 0 o menor con ese golpe, sacar de Grafo y GUI
                          if(arista.peso<=0){
                              ventana.bitacora.append("\nArista fue destruida");
                              ventana.bitacora.append("\n----------------------\n");
                              System.out.println("saque arista:"+arista.dato+" de: "+v.dato);
                              //ventana.matriz.getModel().setValueAt("  ", arista.dato-1, v.dato);
                              matriz.getModel().setValueAt("  ", arista.dato-1, v.dato);
                              iterator.remove();
                          }
                          
                          //System.out.println("\n ---- Y despues ------ ");
                          //System.out.println(arista.peso);
                          //System.out.println(" -----------\n");
                        }  
                    }
                }
                
            }
        }
        
        //ataca su arista espejo (y,x)
        for (Vertice v : vertices){
            if(v.dato == y){
                //ocupamos iterador para quitar arista de arrayList mientras lo recorremos
                for (Iterator<Vertice> iterator = v.aristas.iterator(); iterator.hasNext();) {
                Vertice arista = iterator.next();
                if(arista.dato == x){
                        //ventana.bitacora.append("\nVida antes: "+String.valueOf(arista.peso));
                        System.out.println("\n --- X antes ---");
                        System.out.println(arista.peso);
                        System.out.println(" -----------\n");
                        if(arista.peso>0){
                          arista.peso-=golpe;
                          //ventana.bitacora.append("Vida actual: "+String.valueOf(arista.peso));
                          //si llegó a 0 o menor con ese golpe, sacar de grafo y GUI
                          if(arista.peso<=0){
                              
                              System.out.println("saque arista:"+arista.dato+" de: "+v.dato);
                              //ventana.matriz.getModel().setValueAt("  ", arista.dato-1, v.dato);
                              matriz.getModel().setValueAt("  ", arista.dato-1, v.dato);
                              iterator.remove();
                          }
                          
                          //System.out.println("\n ---- Y despues ------ ");
                          //System.out.println(arista.peso);
                          //System.out.println(" -----------\n");
                        }  
                    }
                }
                
            }
        }
        
        //Si arista es destruida y era soldado, sacar del grafo y de GUI
    }
    
    //elimina por fila
    public void eliminarSoldadosAsociados(int y){
        for(Vertice a: vertices)
            {
                if(a.dato == y)
                {
                    for (Iterator<Vertice> iterator1 = a.aristas.iterator(); iterator1.hasNext();) 
                      {
                        Vertice x1 = iterator1.next();
                        //if(ventana.matriz.getModel().getValueAt(y-1, x1.dato)!=null)
                        if(matriz.getModel().getValueAt(y-1, x1.dato)!=null)
                            {
                               //String valor = ventana.matriz.getModel().getValueAt(y-1, x1.dato).toString(); 
                               String valor = matriz.getModel().getValueAt(y-1, x1.dato).toString(); 
                               if(valor.equals(".."))
                               {
                                  ventana.bitacora.append("\n ---------- \nEliminado");
                                  ventana.bitacora.append("\nSoldado asociado: ("+String.valueOf(y)+","+String.valueOf(x1.dato)+")");
                                  ventana.bitacora.append("\n-----------------");
                                  iterator1.remove();
                                  //ventana.matriz.getModel().setValueAt(" ",y-1, x1.dato);
                                  matriz.getModel().setValueAt(" ",y-1, x1.dato);
                               }
                            }
                                            
                                            
                                            
                      }
                }
            } //fin de lo nuevo
    }
    //elimina por columna
    public void eliminarSoldadosAsociadosAbajo(int y){
        for(Vertice a: vertices)
            {
                
                    for (Iterator<Vertice> iterator1 = a.aristas.iterator(); iterator1.hasNext();) 
                      {
                        Vertice x1 = iterator1.next();
                        if(x1.dato == y){
                          //if(ventana.matriz.getModel().getValueAt(a.dato-1, y)!=null){
                          if(matriz.getModel().getValueAt(a.dato-1, y)!=null){  
                            //String valor = ventana.matriz.getModel().getValueAt(a.dato-1, y).toString(); 
                            String valor = matriz.getModel().getValueAt(a.dato-1, y).toString();
                            if(valor.equals(".."))
                               {
                                   
                                  //ventana.bitacora.append("\n ---------- \nEliminado");
                                  //ventana.bitacora.append("\nSoldado asociado: ("+String.valueOf(y)+","+String.valueOf(y)+")");
                                  //ventana.bitacora.append("\n-----------------");
                                  
                                  iterator1.remove();
                                  //ventana.matriz.getModel().setValueAt(" ",a.dato-1, y);
                                  matriz.getModel().setValueAt(" ",a.dato-1, y);
                                  
                                  
                               }  
                          }
                            
                             
                        }
                        
                                            
                                            
                                            
                      }
                
            } //fin de lo nuevo
    }
    
    public void atacarXYNave(int x,int y,double golpe){
        for (Vertice v : vertices){
            if(v.dato == x){
                //ocupamos iterador para quitar arista de arrayList mientras lo recorremos
                for (Iterator<Vertice> iterator = v.aristas.iterator(); iterator.hasNext();) {
                Vertice arista = iterator.next();
                if(arista.dato == y){
                        System.out.println("\n --- X antes ---");
                        System.out.println(arista.peso);
                        ventana.bitacora.append("\nVida antes: "+String.valueOf(arista.peso));
                        System.out.println(" -----------\n");
                        if(arista.peso>0){
                          arista.peso-=golpe; 
                          ventana.bitacora.append("\nVida actual: "+String.valueOf(arista.peso));
                          //si llegó a 0 o menor con ese golpe, sacar de Grafo y GUI
                          if(arista.peso<=0){
                              ventana.bitacora.append("\nArista fue destruida ");
                              System.out.println("saque arista:"+arista.dato+" de: "+v.dato);
                              //ponemos un "." para que quede la "arista fuente"
                              //ventana.matriz.getModel().setValueAt(".", arista.dato-1, v.dato);
                              matriz.getModel().setValueAt(".", arista.dato-1, v.dato);
                              //no hace falta sacar la arista del grafo, por que queda la fuente sobre la que estaba la nave
                              //iterator.remove();
                              arista.peso=0;
                              
                              
                              //si hay soldados asociados, eliminarlos
                              //y=4 , x=2
                              eliminarSoldadosAsociados(y);
                              eliminarSoldadosAsociadosAbajo(y);
                              
                          }
                          System.out.println("\n ---- Y despues ------ ");
                          System.out.println(arista.peso);
                          System.out.println(" -----------\n");
                        }  
                    }
                }
                
            }
        }
        
        
        //ataca su arista espejo (y,x)
        for (Vertice v : vertices){
            if(v.dato == y){
                //ocupamos iterador para quitar arista de arrayList mientras lo recorremos
                for (Iterator<Vertice> iterator = v.aristas.iterator(); iterator.hasNext();) {
                Vertice arista = iterator.next();
                if(arista.dato == x){
                        System.out.println("\n --- X antes ---");
                        System.out.println(arista.peso);
                        System.out.println(" -----------\n");
                        if(arista.peso>0){
                          arista.peso-=golpe; 
                          //si llegó a 0 o menor con ese golpe, sacar de grafo y GUI
                          if(arista.peso<=0){
                              System.out.println("saque arista:"+arista.dato+" de: "+v.dato);
                              //ponemos un "." para que quede la "arista fuente"
                              //ventana.matriz.getModel().setValueAt(".", arista.dato-1, v.dato);
                              matriz.getModel().setValueAt(".", arista.dato-1, v.dato);
                              //no hace falta sacar la arista del grafo, por que queda la fuente sobre la que estaba la nave
                              //iterator.remove();
                              arista.peso=0;
                              //eliminarSoldadosAsociadosAbajo(x);
                              
                              //si hay soldados asociados, eliminarlos
                              //y=4 , x=2
                              eliminarSoldadosAsociados(x);
                              eliminarSoldadosAsociadosAbajo(x);
                          }
                          System.out.println("\n ---- Y despues ------ ");
                          System.out.println(arista.peso);
                          System.out.println(" -----------\n");
                        }  
                    }
                }
                
            }
        }
        
        //Si arista es destruida y era soldado, sacar del grafo y de GUI
    }
    
    public void generarGrafoEnemigo(){
        //para meter naves solo donde hayan fuentes de poder
        ArrayList<Integer> verticesEnemigo;
        verticesEnemigo = new ArrayList<Integer>();
        
        //para meter naves solo donde hayan fuentes de poder
        ArrayList<Integer> verticesEnemigoNaves;
        verticesEnemigoNaves = new ArrayList<Integer>();
        
        //vertices se meten manual segun cant. nodos matriz
        this.agregarVertice(1);
        this.agregarVertice(2);
        this.agregarVertice(3);
        this.agregarVertice(4);
        this.agregarVertice(5);
        this.agregarVertice(6);
        this.agregarVertice(7);
        this.agregarVertice(8);
        this.agregarVertice(9);
        this.agregarVertice(10);
        
        this.agregarVertice(11);
        this.agregarVertice(12);
        this.agregarVertice(13);
        this.agregarVertice(14);
        this.agregarVertice(15);
        this.agregarVertice(16);
        this.agregarVertice(17);
        this.agregarVertice(18);
        this.agregarVertice(19);
        this.agregarVertice(20);
        
        this.agregarVertice(21);
        this.agregarVertice(22);
        this.agregarVertice(23);
        this.agregarVertice(24);
        this.agregarVertice(25);
        this.agregarVertice(26);
        this.agregarVertice(27);
        this.agregarVertice(28);
        this.agregarVertice(29);
        this.agregarVertice(30);
        
        //meter fuentes de poder , cuantas? cant. aleatoria entre un rango
        Random r1 = new Random();
        int random1 = r1.nextInt(3-1)+1;
        
        while(random1>0){
            Random r2 = new Random();
            int random2 = r2.nextInt(30-2)+2;
            this.agregarFuentePoder(random2);
            verticesEnemigo.add(random2);
            random1--;
            System.out.println(verticesEnemigo);
        }
        //meter naves, cuantas? cant. aleatoria, origen o destino debe ser donde
        //haya fuente de poder.
        Random r3 = new Random();
        //maximo 3 naves en total
        int random3 = r3.nextInt(4-1)+1;
        while(random3>0){
            //fuente de poder random
            Random r4 = new Random();
            int random4 = verticesEnemigo.get(r4.nextInt(verticesEnemigo.size()));
            //destino aleatorio
            Random r5 = new Random();
            int random5 = r5.nextInt(31-1)+1;
            
            //si hay fuente en vertice 2, random4 será ese 2
            this.agregarAristaNave(this.buscarVertice(random5), this.buscarVertice(random4));
            random3--;
            verticesEnemigoNaves.add(random5);
                 
        }
        
        //meter soldados, cuantos? cant. aleatoria, origen o destino debe ser donde
        //haya nave.
        
        Random r6 = new Random();
        //maximo 5 soldados en total
        int random6 = r6.nextInt(6-1)+1;
        while(random6>0){
            //fuente de poder random
            Random r7 = new Random();
            int random7 = verticesEnemigoNaves.get(r7.nextInt(verticesEnemigoNaves.size()));
            //destino aleatorio
            Random r8 = new Random();
            int random8 = r8.nextInt(31-1)+1;
            
            this.agregarAristaSoldado(this.buscarVertice(random7), this.buscarVertice(random8));
            random6--;
                 
        }
        
    }
    
    
    //__________________________________________________________________________
    //__________________________________________________________________________
    
    //agregarAristas pero para cada tipo (nave, fuente poder, soldado)
    
    //luego cuando queramos hacer lo de bajarles vida, etc.. hay que ponerles peso
    
    public void agregarAristaNave(Vertice origen, Vertice destino)
    {   
        
        //System.out.println("soldados "+verticesSoldados);
        if (origen != null && destino != null){
          //solo colocar nave en fuentes de poder
          if(verticesFuentesPoder.contains(origen.dato)|verticesFuentesPoder.contains(destino.dato)){
              
          //no colocar nave si ya hay soldado en ese origen
          if(!verticesSoldados.contains(origen.dato)){
              
              
              //lo elimina de vertices
              //this.eliminar(origen);
              //this.vertices.add(origen.dato-1,origen); 
              
              Random r1 = new Random();
              int random1 = r1.nextInt(1001-100)+100;
             
              origen.agregarAristaNaves(destino,random1);
              //si quiero que sea no-dirigido:
              destino.agregarAristaNaves(origen,random1); 
              
              
          
              //ventana.matriz.getModel().setValueAt(",", origen.dato-1, destino.dato);
              //ventana.matriz.getModel().setValueAt(",", destino.dato-1,origen.dato);
              matriz.getModel().setValueAt(",", origen.dato-1, destino.dato);
              matriz.getModel().setValueAt(",", destino.dato-1,origen.dato);
              
              //aa testing
              verticesNaves.add(destino.dato);
              verticesNaves.add(origen.dato);
              
              verticesNaves2.add(origen.dato);
          } 
          }
          
          else{
              System.out.println("ya hay soldado en esa arista...");
          }
          
        }
            
    }
    
    public void agregarAristaFuente(Vertice origen, Vertice destino)
    {
        if (origen != null && destino != null){
          origen.agregarArista(destino,0);
          //si quiero que sea no-dirigido:
          destino.agregarArista(origen,0); 
         
          //ventana.matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          //ventana.matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
          
          matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
        }
            
    }
    
    public void agregarAristaSoldado(Vertice origen, Vertice destino)
    {   
        
        if (origen != null && destino != null){
          //soldado debe ir en nave (no a la deriva)
          if(verticesNaves2.contains(origen.dato)){
             
            // si no hay una nave en esa arista..
            if (!verticesNaves.contains(destino.dato) ){
                
                //si no está ese soldado ya ocupado en otra nave
                if (!verticesSoldados.contains(destino.dato)){
                    
                    Random r1 = new Random();
                    int random1 = r1.nextInt(501-50)+50;
        
                    origen.agregarArista(destino,random1);
                    //si quiero que sea no-dirigido:
                    destino.agregarArista(origen,random1); 
          
                    //ventana.matriz.getModel().setValueAt("..", origen.dato-1, destino.dato);
                    //ventana.matriz.getModel().setValueAt("..", destino.dato-1,origen.dato);
                    matriz.getModel().setValueAt("..", origen.dato-1, destino.dato);
                    matriz.getModel().setValueAt("..", destino.dato-1,origen.dato);
            
                    verticesSoldados.add(origen.dato);
                    verticesSoldados.add(destino.dato);
            }
                else
                    System.out.println("soldado ya en otra nave");
            
          }
            else
                System.out.println("hay nave en esa arista");
              
          }
          
          else
            System.out.println("soldado debe ir en nave no a la deriva");
        }
        
          else
            System.out.println("origen o destino null");  
    }
    
    
    public void agregarFuentePoder(int valor){
        //verticesFuentesPoder.add(valor);
        // a diferencia de solo arista, este agrega aristas para toda la columna/
        // fila que indiquemos
        
        //valoresAristas = arrayList con los valores (int) de otras aristas..
        //.. con las que arista buscada posee relacion
        //System.out.println(this.buscarVertice(valor).valoresAristas);
        
        //condicion = si en vertice ya hay fuente de poder, no la pone repetida
        if(!this.buscarVertice(valor).valoresAristas.contains(valor)){
            verticesFuentesPoder.add(valor);
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(1));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(2));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(3));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(4));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(5));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(6));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(7));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(8));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(9));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(10)); 
            
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(11));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(12));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(13));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(14));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(15));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(16));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(17));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(18));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(19));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(20));
            
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(21));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(22));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(23));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(24));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(25));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(26));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(27));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(28));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(29));
            this.agregarAristaFuente(this.buscarVertice(valor), this.buscarVertice(30));
        }
        else
            System.out.println("ya hay fuente de poder en ese vertice");
            
        
    }
    
    //__________________________________________________________________________
    //__________________________________________________________________________

    // agrega las aristas con peso
    public void agregarArista(Vertice origen, Vertice destino, int peso)
    {
        if (origen != null && destino != null){
           origen.agregarArista(destino, peso);
           //si quiero que sea no-dirigido:
           destino.agregarArista(origen,peso); 
        }
            
    }

    // busca un vertice en la lista
    public Vertice buscarVertice (int valor){

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).dato == valor)
                return vertices.get(i);
        }

        return null;
    }

    // imprime la lista con sus listas de adyacencia
    public void imprimir ()
    {
        //para cada vertice
        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.print("Vertice "+vertices.get(i).dato+":  ");
            //para cada arista del vertice
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                System.out.print(vertices.get(i).aristas.get(j).dato +"  ");
            }
            System.out.println("");
        }
    }
    
    // imprime la lista con sus listas de adyacencia+ =  tupla (arista y peso)
    public void imprimir3 ()
    {
        //para cada vertice
        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.print("Vertice "+vertices.get(i).dato+":  ");
            //para cada arista del vertice
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                System.out.print(" | ");
                System.out.print("( "+vertices.get(i).aristas.get(j).dato +"  ");
                System.out.print(vertices.get(i).aristas.get(j).peso+" ) ");
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }

    // elimina un vertice, de la lista y de las listas de adyacencia
    public void eliminar (Vertice v)
    {
        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                if (vertices.get(i).aristas.get(j).dato == v.dato)
                    vertices.get(i).aristas.remove(j);
            }
        }

        vertices.remove(v);
    }


    // Recorrido PROFUNDIDAD
    public void profundidad()
    {
        // recorre todos los nodos
        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false)
            {
                visitarAdyacentes(vertices.get(i));
            }
        }

        limpiarVisitados();// quita todos los nodos visitados

    }

    // vissita los nodos en la lista de adyacencia
    public void visitarAdyacentes(Vertice nodo)
    {
        visitarVertice(nodo);
        System.out.print(nodo.dato+"  ");

        // para cada arista
        for (int i = 0; i < nodo.aristas.size(); i++)
        {
            // marca cada uno de los adyacentes
            if (visitadoVertice(nodo.aristas.get(i)) == false)
            {
                visitarAdyacentes(buscarVertice(nodo.aristas.get(i).dato));
            }
        }
    }

    public void visitarVertice(Vertice nodo)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (nodo.dato == vertices.get(i).dato)
                vertices.get(i).visitado = true;
        }
    }

    public boolean visitadoVertice(Vertice nodo)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (nodo.dato == vertices.get(i).dato)
                return vertices.get(i).visitado;
        }
        return false;// si no está
    }

    public void limpiarVisitados(){
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            vertice.visitado = false;
        }
    }
    //----------------------------------------
    public void anchura(Vertice v)
    {
        System.out.print(v.dato+"  ");
        visitarVertice(v);// marca el primer nodo
        ArrayList<Vertice> cola = new ArrayList<Vertice>();
        // mete a la cola los adyacentes del nodo inicial
        for (int i = 0; i < v.aristas.size(); i++) {
            cola.add(buscarVertice(v.aristas.get(i).dato));// es para buscar el nodo en vertices
            visitarVertice(v.aristas.get(i));
            //System.out.println("COLA "+v.aristas.get(i).dato);
        }
        // mientras no se vacíe la cola
        while(!cola.isEmpty())
        {
            // trabaja con el primero de la cola
            Vertice actual = cola.remove(0);
            visitarVertice(actual);
            System.out.print(actual.dato+"  ");
            // cada arista del vertice en la cola
            for (int i = 0; i < actual.aristas.size(); i++) {

                // si no se ha visitado se mete en la cola el adyacente
                if(visitadoVertice(actual.aristas.get(i))==false)
                {
                    // si no está ya en la cola, se mete
                    visitarVertice(buscarVertice(actual.aristas.get(i).dato));
//                    System.out.println("METE"+ actual.aristas.get(i).dato+ "  "+actual.aristas.get(i).visitado);
                    cola.add(actual.aristas.get(i));
                }       
            }
        }
        limpiarVisitados();
    }
    
    //==========================================================================
    //==========================================================================
    //==========================================================================
    //==========================================================================

}