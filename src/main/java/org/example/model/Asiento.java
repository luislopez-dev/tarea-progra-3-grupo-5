/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Academic Project
 * */

package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Asiento {

    private int codigo;
    private Boolean estaOcupado;

    private Boolean ladoVentana;

    private Persona pasajero;

    public Boolean getEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(Boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public Boolean getLadoVentana() {
        return ladoVentana;
    }

    public void setLadoVentana(Boolean ladoVentana) {
        this.ladoVentana = ladoVentana;
    }

    public Persona getPasajero() {
        return pasajero;
    }

    public void setPasajero(Persona pasajero) {
        this.pasajero = pasajero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Asiento() {
    }

    public Asiento(int codigo, Boolean estaOcupado, Boolean ladoVentana, Persona pasajero) {
        this.codigo = codigo;
        this.estaOcupado = estaOcupado;
        this.ladoVentana = ladoVentana;
        this.pasajero = pasajero;
    }
}
