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
public class Wookie {
    //Fuerza
    int [] arrayWookie = new int [8];

    public Wookie() {
        arrayWookie[0] = 20;
        arrayWookie[1] = 80;
        arrayWookie[2] = 25;
        arrayWookie[3] = 0;
        arrayWookie[4] = 80;
        arrayWookie[5] = 5;
        arrayWookie[6] = 30;
        arrayWookie[7] = 40;
    }

    public int[] getArrayWookie() {
        return arrayWookie;
    }

    public void setArrayWookie(int[] arrayWookie) {
        this.arrayWookie = arrayWookie;
    }

    @Override
    public String toString() {
        return "Wookie{" + "arrayWookie=" + arrayWookie + '}';
    }
    
    
}
