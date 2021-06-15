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
public class Mandalorian {
    //Infanteria
    int [] arrayMandalorian = new int [8];

    public Mandalorian() {
        arrayMandalorian[0] = 10;
        arrayMandalorian[1] = 25;
        arrayMandalorian[2] = 90;
        arrayMandalorian[3] = 0;
        arrayMandalorian[4] = 20;
        arrayMandalorian[5] = 60;
        arrayMandalorian[6] = 70;
        arrayMandalorian[7] = 50;
    }

    public int[] getArrayMandalorian() {
        return arrayMandalorian;
    }

    public void setArrayMandalorian(int[] arrayMandalorian) {
        this.arrayMandalorian = arrayMandalorian;
    }

    @Override
    public String toString() {
        return "Mandalorian{" + "arrayMandalorian=" + arrayMandalorian + '}';
    }
    
}
