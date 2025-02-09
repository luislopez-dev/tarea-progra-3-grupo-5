/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Academic Project
 * */
package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus {

    private List<Asiento> asientos;


    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
}
