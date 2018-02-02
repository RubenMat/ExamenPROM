package com.example.dm2.myapplication;

/**
 * Created by dm2 on 02/02/2018.
 */

public class Tiempo {

    String hora,temperatura,cielo;

    public Tiempo(){

        this.hora=null;
        this.temperatura=null;
        this.cielo=null;
    }

    public Tiempo(String hora, String temperatura, String cielo){

        this.hora=hora;
        this.temperatura=temperatura;
        this.cielo=cielo;
    }

    public String getHora() {
        return hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getCielo() {
        return cielo;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
    }
}
