

package grafos;

import java.util.ArrayList;

/**
 *
 * @author dmora
 */
public class Grafo {
    
    //recibe ventana
    principal_gui ventana;
    //tendra arraylist para no repetir aristas entre soldados y naves
    ArrayList<Integer> verticesNaves;
    //tendra arraylist para no repetir aristas entre naves y soldados
    //(no se podra agregar nave si ya hay soldado en ese origen/destino)
    ArrayList<Integer> verticesSoldados;
    
    //profe
    ArrayList<Vertice> vertices;

    public Grafo(principal_gui pVentana)
    {
        vertices = new ArrayList<Vertice>();
        verticesNaves = new ArrayList<Integer>();
        verticesSoldados = new ArrayList<Integer>();
        ventana = pVentana;
    }

    // agrega a la lista
    public void agregarVertice(int valor)
    {
        vertices.add(new Vertice(valor));
    }

    // agrega las aristas
    public void agregarArista(Vertice origen, Vertice destino)
    {
        if (origen != null && destino != null){
          origen.agregarArista(destino);
          //si quiero que sea no-dirigido:
          destino.agregarArista(origen); 
          
          //estos estan ahorita con "." por default, los podemos cambiar
          ventana.matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          ventana.matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
        }
            
    }
    
    
    //__________________________________________________________________________
    //__________________________________________________________________________
    
    //agregarAristas pero para cada tipo (nave, fuente poder, soldado)
    
    //luego cuando queramos hacer lo de bajarles vida, etc.. hay que ponerles peso
    
    public void agregarAristaNave(Vertice origen, Vertice destino)
    {   
        System.out.println("soldados "+verticesSoldados);
        if (origen != null && destino != null){
          if(!verticesSoldados.contains(origen.dato)){
              origen.agregarArista(destino);
              //si quiero que sea no-dirigido:
              destino.agregarArista(origen); 
          

              ventana.matriz.getModel().setValueAt(",", origen.dato-1, destino.dato);
              ventana.matriz.getModel().setValueAt(",", destino.dato-1,origen.dato);
              
              //aa testing
              verticesNaves.add(destino.dato);
              verticesNaves.add(origen.dato);
          }
          else{
              System.out.println("ya hay soldado en esa arista...");
          }
          
        }
            
    }
    
    public void agregarAristaFuente(Vertice origen, Vertice destino)
    {
        if (origen != null && destino != null){
           
          
          origen.agregarArista(destino);
          //si quiero que sea no-dirigido:
          destino.agregarArista(origen); 
          
          ventana.matriz.getModel().setValueAt(".", origen.dato-1, destino.dato);
          ventana.matriz.getModel().setValueAt(".", destino.dato-1,origen.dato);
        }
            
    }
    
    public void agregarAristaSoldado(Vertice origen, Vertice destino)
    {   
        //no dejar poner un soldado en arista donde haya nave
        
        if (origen != null && destino != null){
          if (!verticesNaves.contains(origen.dato) | !verticesNaves.contains(destino.dato)){
            origen.agregarArista(destino);
            //si quiero que sea no-dirigido:
            destino.agregarArista(origen); 
          
            ventana.matriz.getModel().setValueAt("..", origen.dato-1, destino.dato);
            ventana.matriz.getModel().setValueAt("..", destino.dato-1,origen.dato);
            
            verticesSoldados.add(origen.dato);
            verticesSoldados.add(destino.dato);
          }
          else
            System.out.println("ya hay nave en esa arista...");
        }
            
    }
    
    
    public void agregarFuentePoder(int valor){
        // a diferencia de solo arista, este agrega aristas para toda la columna/
        // fila que indiquemos
        
        //valoresAristas = arrayList con los valores (int) de otras aristas..
        //.. con las que arista buscada posee relacion
        System.out.println(this.buscarVertice(valor).valoresAristas);
        
        //condicion = si en vertice ya hay fuente de poder, no la pone repetida
        if(!this.buscarVertice(valor).valoresAristas.contains(valor)){
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
        }
        
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
        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.print("Vertice "+vertices.get(i).dato+":  ");
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                System.out.print(vertices.get(i).aristas.get(j).dato +"  ");
            }
            System.out.println("");
        }
    }

    // elimina un vertice, de la lista y de las listas de adyacencia
    // imprime la lista con sus listas de adyacencia
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

    public void limpiarVisitados()
    {
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




}
