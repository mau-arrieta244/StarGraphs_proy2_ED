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
public class Weekquay {
    //Sigilo
    int [] arrayWeequay = new int [8];

    public Weekquay() {
        arrayWeequay[0] = 40;
        arrayWeequay[1] = 40;
        arrayWeequay[2] = 35;
        arrayWeequay[3] = 0;
        arrayWeequay[4] = 40;
        arrayWeequay[5] = 80;
        arrayWeequay[6] = 30;
        arrayWeequay[7] = 20;
    }

    public int[] getArrayWeequay() {
        return arrayWeequay;
    }

    public void setArrayWeequay(int[] arrayWeequay) {
        this.arrayWeequay = arrayWeequay;
    }

    @Override
    public String toString() {
        return "Weekquay{" + "arrayWeequay=" + arrayWeequay + '}';
    }
    
}
