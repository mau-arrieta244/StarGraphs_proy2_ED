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
public class Gungan {
    //Infanteria
    int [] arrayGungan = new int [8];

    public Gungan() {
        arrayGungan[0] = 30;
        arrayGungan[1] = 20;
        arrayGungan[2] = 45;
        arrayGungan[3] = 0;
        arrayGungan[4] = 60;
        arrayGungan[5] = 0;
        arrayGungan[6] = 55;
        arrayGungan[7] = 10;
    }

    public int[] getArrayGungan() {
        return arrayGungan;
    }

    public void setArrayGungan(int[] arrayGungan) {
        this.arrayGungan = arrayGungan;
    }

    @Override
    public String toString() {
        return "Gungan{" + "arrayGungan=" + arrayGungan + '}';
    }
    
    
}
