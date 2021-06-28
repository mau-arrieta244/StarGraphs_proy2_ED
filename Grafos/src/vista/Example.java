/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.MaxHeap;

/**
 *
 * @author PC
 */
public class Example {
    public static void main(String args[]){
        MaxHeap maxHeap = new MaxHeap(1023);
        maxHeap.insertarHijos(1023);
        //Imprime todos los nodos creados
        for(int i = 1; i <= 1023; i++){
            System.out.println("Número de nodo: " + i);
            System.out.println(maxHeap.getHeap()[i]);
        }
        
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
    }    
}        