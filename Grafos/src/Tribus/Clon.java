/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tribus;

/**
 *
 * @author PC
 */
public class Clon {
    //Cantidad
    int [] arrayClones = new int [8];

    public Clon() {
        arrayClones[0] = 100;
        arrayClones[1] = 5;
        arrayClones[2] = 5;
        arrayClones[3] = 0;
        arrayClones[4] = 0;
        arrayClones[5] = 5;
        arrayClones[6] = 10;
        arrayClones[7] = 20;
    }

    
    public int[] getArrayClones() {
        return arrayClones;
    }

    public void setArrayClones(int[] arrayClones) {
        this.arrayClones = arrayClones;
    }

    @Override
    public String toString() {
        return "Clon{" + "arrayClones=" + arrayClones + '}';
    }
    
}
