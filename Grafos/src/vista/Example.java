/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.MaxHeap;

/**
 *
 * @author PC
 */
public class Example {
    public static void main(String args[]){
//        MaxHeap maxHeap = new MaxHeap(1023);
//        maxHeap.insertarHijos(1023);
//        //Imprime todos los nodos creados
//        for(int i = 1; i <= 1023; i++){
//            System.out.println("Número de nodo: " + i);
//            System.out.println(maxHeap.getHeap()[i]);
//        }
        
//        MaxHeap maxHeap = new MaxHeap(7);
//        maxHeap.insert(1);
//        maxHeap.insert(2);
//        maxHeap.insert(3);
//        maxHeap.insert(4);
//        maxHeap.insert(5);
//        maxHeap.insert(6);
//        maxHeap.insert(7);
//        System.out.println(maxHeap.obtenerPoder(1));
//        System.out.println(maxHeap.obtenerPoder(2));
//        System.out.println(maxHeap.obtenerPoder(3));
//            ArrayList<String> nombresTribus = new ArrayList <String>();
//            nombresTribus.add("clon");
//            nombresTribus.add("ewok");
//            nombresTribus.add("gungan");
//            nombresTribus.add("hutt");
//            nombresTribus.add("jawa");
//            nombresTribus.add("mandalorian");
//            nombresTribus.add("nightsister");
//            nombresTribus.add("sullustano");
//            nombresTribus.add("teek");
//            nombresTribus.add("weekquay");
//            nombresTribus.add("wookie");
//            nombresTribus.add("yuuzhanvong");
//            nombresTribus.remove("clon");
//            System.out.println(nombresTribus);
//            for(int i = 0; i < 11; i++){
//                 System.out.println((int)(Math.random() * 8));
//            }
//            System.out.println(nombresTribus);
        HashMap<String, Double> tribus = new HashMap<String, Double>();
        tribus.put("CR", 2.0);
        System.out.println(tribus);
        tribus.replace("CR", 1.0);
        //tribus.replace("CR", 2.0, 1.0);
        System.out.println(tribus);    
    }
}    