/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import modelo.Tribu;

/**
 *
 * @author PC
 */
public class admTribus {
    private HashMap<String, Double> tribus;  

    public admTribus(HashMap<String, Double> tribus) {
        this.tribus = tribus;
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
            Random rand = new Random();
            int low = 2;
            int high = 11;
            int nCantidad = rand.nextInt(high-low) + low;
            tribu.getArray() [0] = nCantidad;
            //System.out.println("Cantidad : " + tribu.getArray() [0]);
        }
        else{
            tribu.getArray() [0] = 1;
            //System.out.println("Cantidad : " + tribu.getArray() [0]);
        }
    }
    public void ajustarInfanteria(Tribu tribu){
        if(tribu.getArray() [2] >= generadorAleatorio()){
            Random rand = new Random();
            int low = 2;
            int high = 5;
            int numGenerado = rand.nextInt(high-low) + low;
            tribu.getArray() [2] = numGenerado;
//            System.out.println("Infanteria : " + tribu.getArray() [2]);
        }
        else{
            tribu.getArray() [2] = 1;
//            System.out.println("Infanteria : " + tribu.getArray() [2]);
        }
    }
    //Esta función se encarga de ajustar los poderes de las tribus enemigas
    //de forma aleatoria.
    public ArrayList<String> crearArrayListPoderes(){
        ArrayList<String> nombresPoderes = new ArrayList <String>();
        nombresPoderes.add("cantidad");
        nombresPoderes.add("fuerza");
        nombresPoderes.add("infanteria");
        nombresPoderes.add("lado oscuro");
        nombresPoderes.add("riqueza");
        nombresPoderes.add("sigilo");
        nombresPoderes.add("tecnologia");
        nombresPoderes.add("velocidad");
        return nombresPoderes;
    }
    public boolean ajustarRiqueza(Tribu tribu, String pAtributo){
        String atributo;
        if(pAtributo.equalsIgnoreCase("")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el atributo que quiere aumentar segun la riqueza: " + tribu.getArray() [4]);
            atributo = scanner.nextLine();
        }
        else{
            atributo = pAtributo;
        }
        System.out.println("******Riqueza******");
        if(atributo.equalsIgnoreCase("cantidad")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [0] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [1] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);            
            tribu.getArray() [2] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [3] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            System.out.println("No puede seleccionar riqueza.");
            return false;
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [5] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [6] += tribu.getArray() [4];
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [4] + 
            " al atributo " + atributo);
            tribu.getArray() [7] += tribu.getArray() [4];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }
    public boolean ajustarTecnologia(Tribu tribu, String pAtributo){
        String atributo;
        if(pAtributo.equalsIgnoreCase("")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el atributo que quiere aumentar segun la tecnologia: " + tribu.getArray() [6]);
            atributo = scanner.nextLine();
        }
        else{
            atributo = pAtributo;
        }
        System.out.println("******Tecnologia******");
        if(atributo.equalsIgnoreCase("cantidad")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + "en " + tribu.getArray() [0]);
            tribu.getArray() [0] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [1]);
            tribu.getArray() [1] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [2]);
            tribu.getArray() [2] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [3]);
            tribu.getArray() [3] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [4]);
            tribu.getArray() [4] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [5]);
            tribu.getArray() [5] += tribu.getArray() [6];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            System.out.println("No puede seleccionar tecnologia.");
            return false;
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            System.out.println("Se decidió aumentar en " + tribu.getArray() [6] + 
            " al atributo " + atributo + " en " + tribu.getArray() [7]);
            tribu.getArray() [7] += tribu.getArray() [6];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }
    public boolean isLimiteResta(Tribu tribu1, Tribu tribu2, String atributo){
        if(atributo.equalsIgnoreCase("cantidad")){
            if((tribu2.getArray() [0] - tribu1.getArray() [5]) >= 5){
                return true;
            }       
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            if((tribu2.getArray() [1] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            if((tribu2.getArray() [2] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            if((tribu2.getArray() [3] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            if((tribu2.getArray() [4] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            if((tribu2.getArray() [5] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            if((tribu2.getArray() [6] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            if((tribu2.getArray() [6] - tribu1.getArray() [5]) >= 5){
                return true;
            }    
        }
        return false;
    }
    public boolean ajustarSigilo(Tribu tribu1, Tribu tribu2, String pAtributo){
        String atributo;
        if(pAtributo.equalsIgnoreCase("")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el atributo que quiere disminuir segun el sigilo: " 
                    + tribu1.getArray() [5]);
            atributo = scanner.nextLine();
            boolean isInLimit = isLimiteResta(tribu1, tribu2, atributo);
            while(isInLimit == false){
                System.out.println("El atributo ingresado no es permitido reducirlo, debido a que su "
                        + "resta es menor que 5.");
                System.out.println("Ingrese el atributo que quiere disminuir segun el sigilo: " + tribu1.getArray() [5]);
                atributo = scanner.nextLine();
                isInLimit = isLimiteResta(tribu1, tribu2, atributo);
            }
        }
        else{
           atributo = pAtributo; 
        }
        System.out.println("******Sigilo******");
        if(atributo.equalsIgnoreCase("cantidad")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [0]);
            tribu2.getArray() [0] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("fuerza")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [1]);
            tribu2.getArray() [1] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("infanteria")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [2]);
            tribu2.getArray() [2] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("lado oscuro")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [3]);
            tribu2.getArray() [3] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("riqueza")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [4]);
            tribu2.getArray() [4] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("sigilo")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [5]);
            tribu2.getArray() [5] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("tecnologia")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [6]);
            tribu2.getArray() [6] -= tribu1.getArray() [5];
        }
        else if(atributo.equalsIgnoreCase("velocidad")){
            System.out.println("Se decidió disminuir " + tribu1.getArray() [5] + 
            " al atributo " + atributo + " que es igual a " + tribu2.getArray() [7]);
            tribu2.getArray() [7] -= tribu1.getArray() [5];
        }
        else{
            System.out.println("El atributo ingresado no existe.");
            return false;
        }
        return true;
    }

    public void ajustarPoderes(Tribu tribu1, Tribu tribu2){
        System.out.println("\n--------------Tribu " +tribu1.getNombre() +" del jugador--------------");
        ajustarCantidad(tribu1);
        //Fuerza no ocupa modificacion
        ajustarInfanteria(tribu1);
        //Lado oscuro no ocupa modificacion
        boolean valorRiqueza = ajustarRiqueza(tribu1, "");
        while(valorRiqueza == false){
            valorRiqueza = ajustarRiqueza(tribu1, "");
        }
        boolean valorSigilo = ajustarSigilo(tribu1, tribu2, "");
        while(valorSigilo == false){
            valorSigilo = ajustarSigilo(tribu1, tribu2, "");
        }
        boolean valorTecnologia = ajustarTecnologia(tribu1, "");
        while(valorTecnologia == false){
            valorTecnologia = ajustarTecnologia(tribu1, "");
        }
        System.out.println("\n");
        //La velocidad no ocupa modificacion.
    }

    public void ajustarPoderes2(Tribu tribuEnemiga, Tribu tribuJugador){
        System.out.println("\n--------------Tribu " +tribuEnemiga.getNombre() +" enemiga--------------");
        ArrayList<String> nombresPoderes = crearArrayListPoderes();
        ajustarCantidad(tribuEnemiga);
        //Fuerza no ocupa modificacion
        ajustarInfanteria(tribuEnemiga);
        //Lado oscuro no ocupa modificacion
        String atributo = nombresPoderes.get((int)(Math.random() * 8));
        boolean valorRiqueza = ajustarRiqueza(tribuEnemiga, atributo);
        while(valorRiqueza == false){
            atributo = nombresPoderes.get((int)(Math.random() * 8));
            valorRiqueza = ajustarRiqueza(tribuEnemiga, atributo);
        }
        atributo = nombresPoderes.get((int)(Math.random() * 8));
        boolean isInLimit = isLimiteResta(tribuEnemiga, tribuJugador, atributo);
        int i = 8;
        while(isInLimit == false){
            atributo = nombresPoderes.get((int)(Math.random() * 8));
            isInLimit = isLimiteResta(tribuEnemiga, tribuJugador, atributo);
            if(i == 0){
                break;
            }
            i--;
        }
        if(i == 0){
            System.out.println("No se pudo hacer la disminución con el sigiloporque no "
                    + "existe algun atributo que al restarlo el resultado "
                    + "sea mayor que 5.");
        }
        if(i != 0){
            ajustarSigilo(tribuEnemiga, tribuJugador, atributo);
        }
        atributo = nombresPoderes.get((int)(Math.random() * 8));
        boolean valorTecnologia = ajustarTecnologia(tribuEnemiga, atributo);
        
        while(valorTecnologia == false){
            atributo = nombresPoderes.get((int)(Math.random() * 8));
            valorTecnologia = ajustarTecnologia(tribuEnemiga, atributo);
        }
        System.out.println("\n");
    }
    public double determinarGolpe(Tribu tribu){
        double porcentajeLadoOscuro = 0;
        double porcentajeVelocidad;
        double golpe;
        //Solo el numPorcentaje se usa en nightsisters.
        if(tribu.getArray() [3] > 0){
            porcentajeLadoOscuro = 1 + (tribu.getArray() [3] / 100);
        }
        porcentajeVelocidad = 1 + (tribu.getArray() [7] * 1.0 / 100 * 1.0);
        if(porcentajeLadoOscuro == 0){
            golpe = ((tribu.getArray() [0] * tribu.getArray() [1]) * 
                porcentajeVelocidad) * tribu.getArray() [2];
        }
        else{
            golpe = ((tribu.getArray() [0] * tribu.getArray() [1]) * 
                porcentajeVelocidad * porcentajeLadoOscuro) * tribu.getArray() [2];
        }
        return golpe;
    }
    public void imprimirAtributos(Tribu tribu){
        System.out.println("\n--------------Tribu " + tribu.getNombre() + " --------------");
        System.out.println("Cantidad: " +tribu.getArray() [0]);
        System.out.println("Fuerza: " +tribu.getArray() [1]);
        System.out.println("Infanteria: " +tribu.getArray() [2]);
        System.out.println("Lado oscuro: " +tribu.getArray() [3]);
        System.out.println("Riqueza: " +tribu.getArray() [4]);
        System.out.println("Sigilo: " +tribu.getArray() [5]);
        System.out.println("Tecnologia: " +tribu.getArray() [6]);
        System.out.println("Velocidad: " + tribu.getArray() [7]);
        System.out.println("Fuerza: " + determinarGolpe(tribu));
        
    }
    //Esta funcion se usa para obtener los nombres de las tribus sin
    //repetir.
    public String nombreRandom(String tribuJugador){
        int num = (int)(Math.random() * 12);
        String nombreTribu = "";
        switch(num){
            case 0:
                nombreTribu = "clon";
                break;
            case 1:
                nombreTribu = "ewok";
                break;
            case 2:
                nombreTribu = "gungan";
                break;
            case 3:
                nombreTribu = "hutt";
                break;
            case 4:
                nombreTribu = "jawa";
                break;
            case 5:
                nombreTribu = "mandalorian";
                break;
            case 6:
                nombreTribu = "nightsister";
                break;
            case 7:
                nombreTribu = "sullustano";
                break;
            case 8:
                nombreTribu = "teek";
                break;
            case 9:
                nombreTribu = "weekquay";
                break;
            case 10:
                nombreTribu = "wookie";
                break;
            case 11:
                nombreTribu = "yuuzhanvong";
                break;
        }
        if(nombreTribu.equalsIgnoreCase(tribuJugador)){
            return nombreRandom(tribuJugador);
        }
        return nombreTribu;
    }    
    //Esta funcion se encarga de iniciar los parametros de todas las tribus
    //al comienzo de la partida. Para ir incrementando los poderes 
    //nada mas se toma como referencia la tribu y se hacen los cambios respectivos.
    public Tribu crearTribus(Tribu tribuJugador){
        if(tribuJugador != null){
            System.out.println("Tribu del jugador: " + tribuJugador.getNombre());
            String nombreTribuEnemiga = nombreRandom(tribuJugador.getNombre());
            Tribu tribuEnemiga = crearTribu(nombreTribuEnemiga);
            System.out.println("Tribu enemiga: " + nombreTribuEnemiga);
            ajustarPoderes(tribuJugador, tribuEnemiga);
            ajustarPoderes2(tribuEnemiga, tribuJugador);
            tribus.put(tribuJugador.getNombre(), determinarGolpe(tribuJugador));
            imprimirAtributos(tribuJugador);
            System.out.println("\n");
            tribus.put(tribuEnemiga.getNombre(), determinarGolpe(tribuEnemiga));
            imprimirAtributos(tribuEnemiga);
            System.out.println("\n");
            System.out.println("Tribus creadas");
            System.out.println(tribus);
            System.out.println("\n");
            //Se devuelve la tribu enemiga para poder trabajar con ella.
            return tribuEnemiga;
        }
        System.out.println("El nombre de la tribu elegida no existe.");
        return null;
    }
    public Tribu crearTribus2(Tribu tribuJugador, Tribu tribuDerrotada){
        if(tribuJugador != null){
            System.out.println("Tribu del jugador: " + tribuJugador.getNombre());
            String nombreTribuEnemiga = nombreRandom(tribuJugador.getNombre());
            Tribu tribuEnemiga = crearTribu(nombreTribuEnemiga);
            System.out.println("Tribu enemiga: " + nombreTribuEnemiga);
            //El actualizar tribu se usa para aumentar los atributos de la tribu del jugador
            //al momento de la evolucion.
            //actualizarTribu(tribuJugador, tribuDerrotada);
            imprimirAtributos(tribuJugador);
            System.out.println("\n");
            ajustarPoderes2(tribuEnemiga, tribuJugador);
            tribus.put(tribuEnemiga.getNombre(), determinarGolpe(tribuEnemiga));
            imprimirAtributos(tribuEnemiga);
            System.out.println("\n");
            System.out.println("Tribus creadas");
            System.out.println(tribus);
            System.out.println("\n");
            //Se devuelve la tribu enemiga para poder trabajar con ella.
            return tribuEnemiga;
        }
        System.out.println("El nombre de la tribu elegida no existe.");
        return null;
    }
//    public int extraerPoderContrario(){
//        
//    }
    //Esta funcion se encarga de actualizar una tribu cuando esta llega a 
    //evolucionar, a partir de esto los datos dentro del hash map que le pertenecen
    //se actualizan.
//    public void actualizarTribu(Tribu tribuJugador, Tribu tribuDerrotada){
//        if(tribuJugador != null){
//            System.out.println(tribus);
//                Dentro de esta parte comentada se puede evolucionar la especie
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Ingrese el atributo del enemigo que desea obtener: " + tribu.getArray() [4]);
//            atributo = scanner.nextLine();
//            extraerPoderContrario();
//            
//            
//            
//            tribus.replace(tribuJugador.getNombre(), determinarGolpe(tribuJugador));
//            System.out.println(tribus);
//            System.out.println("Hash map actualizado con los nuevos poderes de la tribu del jugador.");
//        }
//        else{
//            System.out.println("La tribu elegida no existe.");
//        }
//    }
    @Override
    public String toString() {
        return "admTribus{" + "tribus=" + tribus + '}';
    }
    
}
