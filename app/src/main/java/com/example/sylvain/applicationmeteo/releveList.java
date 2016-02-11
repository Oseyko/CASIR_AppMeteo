package com.example.sylvain.applicationmeteo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sylvain on 11/02/2016.
 */
public class releveList {
    public static ArrayList<Releve> releveList;


    public static Releve getReleveByDate(Date date){
        for (Releve r : releveList){
            if(r.getDateReleve().equals(date)){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Releve> getArrayList(){
        return this.releveList;
    }
}
