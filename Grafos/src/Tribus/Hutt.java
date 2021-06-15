package Tribus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Hutt {
    //Riqueza
    int [] arrayHutt = new int [8];

    public Hutt() {
        arrayHutt[0] = 10;
        arrayHutt[1] = 10;
        arrayHutt[2] = 40;
        arrayHutt[3] = 0;
        arrayHutt[4] = 90;
        arrayHutt[5] = 10;
        arrayHutt[6] = 50;
        arrayHutt[7] = 0;
    }

    public int[] getArrayHutt() {
        return arrayHutt;
    }

    public void setArrayHutt(int[] arrayHutt) {
        this.arrayHutt = arrayHutt;
    }

    @Override
    public String toString() {
        return "Hutt{" + "arrayHutt=" + arrayHutt + '}';
    }
    
}
