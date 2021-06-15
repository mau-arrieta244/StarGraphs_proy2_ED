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
public class Yuuzhanvong {
    //Tecnologia
    int [] arrayYuuzhanvong = new int [8];

    public Yuuzhanvong() {
        arrayYuuzhanvong[0] = 20;
        arrayYuuzhanvong[1] = 15;
        arrayYuuzhanvong[2] = 80;
        arrayYuuzhanvong[3] = 0;
        arrayYuuzhanvong[4] = 50;
        arrayYuuzhanvong[5] = 10;
        arrayYuuzhanvong[6] = 90;
        arrayYuuzhanvong[7] = 40;
    }

    public int[] getArrayYuuzhanvong() {
        return arrayYuuzhanvong;
    }

    public void setArrayYuuzhanvong(int[] arrayYuuzhanvong) {
        this.arrayYuuzhanvong = arrayYuuzhanvong;
    }

    @Override
    public String toString() {
        return "Yuuzhanvong{" + "arrayYuuzhanvong=" + arrayYuuzhanvong + '}';
    }
    
}
