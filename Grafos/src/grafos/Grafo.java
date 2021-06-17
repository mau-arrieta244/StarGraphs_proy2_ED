

package grafos;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Tribu;
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
    public Tribu crearTribu(String nombreTribu){
        Tribu tribu;
        if(nombreTribu.equalsIgnoreCase("clon")){
            //Cantidad
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 100; 
            tribu.getArray() [1] = 5; 
            tribu.getArray() [2] = 5; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 0; 
            tribu.getArray() [5] = 5; 
            tribu.getArray() [6] = 10; 
            tribu.getArray() [7] = 20; 
            return tribu;  
        }
        else if(nombreTribu.equalsIgnoreCase("ewok")){
            //Cantidad
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 80; 
            tribu.getArray() [1] = 5; 
            tribu.getArray() [2] = 5; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 0; 
            tribu.getArray() [5] = 50; 
            tribu.getArray() [6] = 0; 
            tribu.getArray() [7] = 20; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("gungan")){
            //Infanteria
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 30; 
            tribu.getArray() [1] = 20; 
            tribu.getArray() [2] = 45; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 60; 
            tribu.getArray() [5] = 0; 
            tribu.getArray() [6] = 55; 
            tribu.getArray() [7] = 10; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("hutt")){
            //Riqueza
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 10; 
            tribu.getArray() [1] = 10; 
            tribu.getArray() [2] = 40; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 90; 
            tribu.getArray() [5] = 10; 
            tribu.getArray() [6] = 50; 
            tribu.getArray() [7] = 0; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("jawa")){
            //Sigilo
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 50; 
            tribu.getArray() [1] = 20; 
            tribu.getArray() [2] = 50; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 50; 
            tribu.getArray() [5] = 80; 
            tribu.getArray() [6] = 50; 
            tribu.getArray() [7] = 5; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("mandalorian")){
            //Infanteria
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 10; 
            tribu.getArray() [1] = 25; 
            tribu.getArray() [2] = 90; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 20; 
            tribu.getArray() [5] = 60; 
            tribu.getArray() [6] = 70; 
            tribu.getArray() [7] = 50; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("nightsister")){
            //Lado oscuro
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 0; 
            tribu.getArray() [1] = 50; 
            tribu.getArray() [2] = 20; 
            tribu.getArray() [3] = 50; 
            tribu.getArray() [4] = 0; 
            tribu.getArray() [5] = 40; 
            tribu.getArray() [6] = 10; 
            tribu.getArray() [7] = 40; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("sullustano")){
            //Tecnologia
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 30; 
            tribu.getArray() [1] = 10; 
            tribu.getArray() [2] = 80; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 80; 
            tribu.getArray() [5] = 20; 
            tribu.getArray() [6] = 85; 
            tribu.getArray() [7] = 10; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("teek")){
            //Velocidad
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 20; 
            tribu.getArray() [1] = 20; 
            tribu.getArray() [2] = 0; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 0; 
            tribu.getArray() [5] = 80; 
            tribu.getArray() [6] = 0; 
            tribu.getArray() [7] = 80; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("weekquay")){
            //Sigilo
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 40; 
            tribu.getArray() [1] = 40; 
            tribu.getArray() [2] = 35; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 40; 
            tribu.getArray() [5] = 80; 
            tribu.getArray() [6] = 30; 
            tribu.getArray() [7] = 20; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("wookie")){
            //Fuerza
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 20; 
            tribu.getArray() [1] = 80; 
            tribu.getArray() [2] = 25; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 80; 
            tribu.getArray() [5] = 5; 
            tribu.getArray() [6] = 30; 
            tribu.getArray() [7] = 40; 
            return tribu;
        }
        else if(nombreTribu.equalsIgnoreCase("yuuzhanvong")){
            //Tecnologia
            tribu = new Tribu();
            tribu.setNombre(nombreTribu);
            tribu.getArray() [0] = 20; 
            tribu.getArray() [1] = 15; 
            tribu.getArray() [2] = 80; 
            tribu.getArray() [3] = 0; 
            tribu.getArray() [4] = 50; 
            tribu.getArray() [5] = 10; 
            tribu.getArray() [6] = 90; 
            tribu.getArray() [7] = 40; 
            return tribu;
        }
        return null;     
    }
    public int generadorAleatorio(){
        return (int)(Math.random() * 101); 
    }
    public void ajustarCantidad(Tribu tribu){
        if(tribu.getArray() [0] >= generadorAleatorio()){
            int nCantidad = (int)(Math.random() * 9) + 2;
            tribu.getArray() [0] = nCantidad;
            System.out.println("Cantidad : " + tribu.getArray() [0]);
        }
        else{
            tribu.getArray() [0] = 1;
            System.out.println("Cantidad : " + tribu.getArray() [0]);
        }
    }
    public void ajustarInfanteria(Tribu tribu){
        if(tribu.getArray() [2] == generadorAleatorio()){
            int numGenerado = (int)(Math.random() * 3) + 2;
            tribu.getArray() [2] = numGenerado;
            System.out.println("Infanteria : " + tribu.getArray() [2]);
        }
        else{
            tribu.getArray() [2] = 1;
            System.out.println("Infanteria : " + tribu.getArray() [2]);
        }
    }
    public boolean ajustarRiqueza(Tribu tribu){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el atributo que quiere aumentar segun la riqueza: " + tribu.getArray() [4]);
        String atributo = scanner.nextLine();
        if(atributo.equalsIgnoreCase("cantidad")){
            tribu.getArray() [0] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            tribu.getArray() [1] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            tribu.getArray() [2] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            tribu.getArray() [3] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            System.out.println("No puede seleccionar riqueza.");
            return false;
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            tribu.getArray() [5] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            tribu.getArray() [6] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            tribu.getArray() [7] += tribu.getArray() [4];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }
    public boolean ajustarSigilo(Tribu tribu1, Tribu tribu2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el atributo que quiere disminuir segun el sigilo: " + tribu1.getArray() [4]);
        String atributo = scanner.nextLine();
        if(atributo.equalsIgnoreCase("cantidad")){
            tribu2.getArray() [0] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            tribu2.getArray() [1] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            tribu2.getArray() [2] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            tribu2.getArray() [3] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            tribu2.getArray() [4] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            tribu2.getArray() [5] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            tribu2.getArray() [6] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            tribu2.getArray() [7] -= tribu1.getArray() [5];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }
    public boolean ajustarTecnologia(Tribu tribu){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el atributo que quiere aumentar segun la tecnologia: " + tribu.getArray() [6]);
        String atributo = scanner.nextLine();
        if(atributo.equalsIgnoreCase("cantidad")){
            tribu.getArray() [0] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            tribu.getArray() [1] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            tribu.getArray() [2] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            tribu.getArray() [3] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            tribu.getArray() [4] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            tribu.getArray() [5] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            System.out.println("No puede seleccionar tecnologia.");
            return false;
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            tribu.getArray() [7] += tribu.getArray() [6];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }
    public void ajustarPoderes(Tribu tribu1, Tribu tribu2){
        ajustarCantidad(tribu1);
        //Fuerza no ocupa modificacion
        ajustarInfanteria(tribu1);
        //Lado oscuro no ocupa modificacion
        boolean valorRiqueza = ajustarRiqueza(tribu1);
        while(valorRiqueza == false){
            valorRiqueza = ajustarRiqueza(tribu1);
        }
        boolean valorSigilo = ajustarSigilo(tribu1, tribu2);
        while(valorSigilo == false){
            valorSigilo = ajustarRiqueza(tribu1);
        }
        boolean valorTecnologia = ajustarTecnologia(tribu1);
        while(valorTecnologia == false){
            valorTecnologia = ajustarTecnologia(tribu1);
        }
        //La velocidad no ocupa modificacion.
    }
    //Tomar en cuenta el otro ajuste de los parametros de la tribu 2.    
    //Posteriormente se eliminaran los parametros al integrar la GUI
    public void iniciarPoderes(String nombre1, String nombre2){
        Tribu tribu1 = crearTribu(nombre1);
        if(tribu1 != null){
            System.out.println("Tribu " + nombre1 + "generada.");
            Tribu tribu2 = crearTribu(nombre2);
            if(tribu2 != null){
                System.out.println("Tribu " + nombre2 + "generada.");
                System.out.println(tribu1);
                System.out.println(tribu2);
                ajustarPoderes(tribu1, tribu2);
            }
            else{
                System.out.println("El nombre de la tribu 2 no existe.");
            }
        }
        else{
            System.out.println("El nombre de la tribu 1 no existe.");
        }
    }
}