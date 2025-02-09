/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Academic Project
 * */

package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Asiento;
import org.example.model.Persona;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbConfig {

    public static void generarArchivoInicial(String nombreArchivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Asiento> asientos = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            boolean ladoVentana = (i % 2 == 0);
            Asiento asiento = new Asiento(i, false, ladoVentana, new Persona());
            asientos.add(asiento);
        }

        try {
            objectMapper.writeValue(new File(nombreArchivo), asientos);
            System.out.println("Archivo JSON generado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
