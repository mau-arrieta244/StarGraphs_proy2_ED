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
public class Jawa {
    //Sigilo
    int [] arrayJawa = new int [8];

    public Jawa() {
        arrayJawa[0] = 50;
        arrayJawa[1] = 20;
        arrayJawa[2] = 50;
        arrayJawa[3] = 0;
        arrayJawa[4] = 50;
        arrayJawa[5] = 80;
        arrayJawa[6] = 50;
        arrayJawa[7] = 5;
    }

    public int[] getArrayJawa() {
        return arrayJawa;
    }

    public void setArrayJawa(int[] arrayJawa) {
        this.arrayJawa = arrayJawa;
    }

    @Override
    public String toString() {
        return "Jawa{" + "arrayJawa=" + arrayJawa + '}';
    }
}
