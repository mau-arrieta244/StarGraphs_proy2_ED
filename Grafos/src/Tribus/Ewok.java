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
public class Ewok {
    //Cantidad
    int [] arrayEwok = new int [8];

    public Ewok() {
        arrayEwok[0] = 80;
        arrayEwok[1] = 5;
        arrayEwok[2] = 5;
        arrayEwok[3] = 0;
        arrayEwok[4] = 0;
        arrayEwok[5] = 50;
        arrayEwok[6] = 0;
        arrayEwok[7] = 20;
    }

    public int[] getArrayEwok() {
        return arrayEwok;
    }

    public void setArrayEwok(int[] arrayEwok) {
        this.arrayEwok = arrayEwok;
    }

    @Override
    public String toString() {
        return "Ewok{" + "arrayEwok=" + arrayEwok + '}';
    }
    
}
