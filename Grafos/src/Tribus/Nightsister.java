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
public class Nightsister {
    //Lado oscuro
    int [] arrayNightsisters = new int [8];

    public Nightsister() {
        arrayNightsisters[0] = 0;
        arrayNightsisters[1] = 50;
        arrayNightsisters[2] = 20;
        arrayNightsisters[3] = 50;
        arrayNightsisters[4] = 0;
        arrayNightsisters[5] = 40;
        arrayNightsisters[6] = 10;
        arrayNightsisters[7] = 40;
    }

    public int[] getArrayNightsisters() {
        return arrayNightsisters;
    }

    public void setArrayNightsisters(int[] arrayNightsisters) {
        this.arrayNightsisters = arrayNightsisters;
    }

    @Override
    public String toString() {
        return "Nightsisters{" + "arrayNightsisters=" + arrayNightsisters + '}';
    }
    
    
}
