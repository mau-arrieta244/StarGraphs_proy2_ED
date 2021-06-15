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
public class Sullustano {
    //Tecnologia
    int [] arraySullustanos = new int [8];
    
    public Sullustano() {
        arraySullustanos[0] = 30;
        arraySullustanos[1] = 10;
        arraySullustanos[2] = 80;
        arraySullustanos[3] = 0;
        arraySullustanos[4] = 80;
        arraySullustanos[5] = 20;
        arraySullustanos[6] = 85;
        arraySullustanos[7] = 10;
    }

    public int[] getArraySullustanos() {
        return arraySullustanos;
    }

    public void setArraySullustanos(int[] arraySullustanos) {
        this.arraySullustanos = arraySullustanos;
    }

    @Override
    public String toString() {
        return "Sullustanos{" + "arraySullustanos=" + arraySullustanos + '}';
    }
    
}
