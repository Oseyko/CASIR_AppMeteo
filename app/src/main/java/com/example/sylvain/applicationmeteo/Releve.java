package com.example.sylvain.applicationmeteo;

import java.util.Date;

/**
 * Created by Sylvain on 11/02/2016.
 */
public class Releve {
    private Date dateReleve;
    private float temperatureOne;
    private float temperatureTwo;
    private float pressure;

    public Releve(Date dateReleve, float temperatureOne, float temperatureTwo, float pressure) {
        this.dateReleve = dateReleve;
        this.temperatureOne = temperatureOne;
        this.temperatureTwo = temperatureTwo;
        this.pressure = pressure;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public float getTemperatureOne() {
        return temperatureOne;
    }

    public void setTemperatureOne(float temperatureOne) {
        this.temperatureOne = temperatureOne;
    }

    public float getTemperatureTwo() {
        return temperatureTwo;
    }

    public void setTemperatureTwo(float temperatureTwo) {
        this.temperatureTwo = temperatureTwo;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
