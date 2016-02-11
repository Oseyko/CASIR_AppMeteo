package com.example.sylvain.applicationmeteo;

import java.util.ArrayList;

/**
 * Created by Sylvain on 10/02/2016.
 */
public class stationList {
    public static ArrayList<Station> stationList;

    public static Station getStationById(String id){
        for(Station s : stationList){
            if(s.getIdStation().equals(id)){
                return s ;
            }
        }
        return null ;
    }
}
