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
public class Teek {
    //Velocidad
    int [] arrayTeek = new int [8];

    public Teek() {
        arrayTeek[0] = 20;
        arrayTeek[1] = 20;
        arrayTeek[2] = 0;
        arrayTeek[3] = 0;
        arrayTeek[4] = 0;
        arrayTeek[5] = 80;
        arrayTeek[6] = 0;
        arrayTeek[7] = 80;
    }

    public int[] getArrayTeek() {
        return arrayTeek;
    }

    public void setArrayTeek(int[] arrayTeek) {
        this.arrayTeek = arrayTeek;
    }

    @Override
    public String toString() {
        return "Teek{" + "arrayTeek=" + arrayTeek + '}';
    }
    
}
