package com.example.sylvain.applicationmeteo;

/**
 * Created by Sylvain on 10/02/2016.
 */
public class Station {
    private String idStation;
    private String libelleStation;
    private String latitudeStation;
    private String longitudeStation;
    private String altitudeStation;
    private boolean favoriteStation;

    public Station(String id, String libelle, String latitude, String longitude, String altitude) {
        this.idStation = id;
        this.libelleStation = libelle;
        this.latitudeStation = latitude;
        this.longitudeStation = longitude;
        this.altitudeStation = altitude;
        this.favoriteStation = false;
    }

    public boolean isFavoriteStation() {
        return favoriteStation;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getLibelleStation() {
        return libelleStation;
    }

    public void setLibelleStation(String libelleStation) {
        this.libelleStation = libelleStation;
    }

    public String getLatitudeStation() {
        return latitudeStation;
    }

    public void setLatitudeStation(String latitudeStation) {
        this.latitudeStation = latitudeStation;
    }

    public String getLongitudeStation() {
        return longitudeStation;
    }

    public void setLongitudeStation(String longitudeStation) {
        this.longitudeStation = longitudeStation;
    }

    public String getAltitudeStation() {
        return altitudeStation;
    }

    public void setAltitudeStation(String altitudeStation) {
        this.altitudeStation = altitudeStation;
    }

    public void toggleFavorite(){
        if (this.favoriteStation) {
            this.favoriteStation=false;
        }else{
            this.favoriteStation=true;
        }
    }
}
