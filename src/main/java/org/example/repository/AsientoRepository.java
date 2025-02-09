/*
 *
 * Website: https://github.com/luislopez-dev
 * Description: Academic Project
 * */

package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Asiento;
import org.example.model.Persona;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AsientoRepository {

    private static final File fichero = new File("fichero.json");
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void RegistrarPasajero(Persona pasajero, int asientoNumero) throws IOException {
        List<Asiento> asientos = obtenerAsientos();

        for (Asiento asiento : asientos) {
            if (asiento.getCodigo() == asientoNumero) {
                if (!asiento.getEstaOcupado()) {
                    asiento.setPasajero(pasajero);
                    asiento.setEstaOcupado(true);
                    System.out.println("Pasajero registrado en el asiento " + asientoNumero);
                    guardarAsientos(asientos);
                } else {
                    System.out.println("El asiento " + asientoNumero + " ya está ocupado.");
                }
                return;
            }
        }
        System.out.println("El asiento " + asientoNumero + " no existe.");
    }

    public static void VerificarAsientoDisponibilidad(int asientoNumero) {
        try {
            List<Asiento> asientos = obtenerAsientos();
            for (Asiento asiento : asientos) {
                if (asiento.getCodigo() == asientoNumero) {
                    if (asiento.getEstaOcupado()) {
                        System.out.println("El asiento " + asientoNumero + " está ocupado.");
                    } else {
                        System.out.println("El asiento " + asientoNumero + " está disponible.");
                    }
                    return;
                }
            }
            System.out.println("El asiento " + asientoNumero + " no existe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verAsientoUbicacion(int asientoNumero) {
        try {
            List<Asiento> asientos = obtenerAsientos();
            for (Asiento asiento : asientos) {
                if (asiento.getCodigo() == asientoNumero) {
                    if (asiento.getLadoVentana()) {
                        System.out.println("El asiento " + asientoNumero + " está junto a la ventana.");
                    } else {
                        System.out.println("El asiento " + asientoNumero + " no está junto a la ventana.");
                    }
                    return;
                }
            }
            System.out.println("El asiento " + asientoNumero + " no existe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verDatosPasajero(int asientoNumero) {
        try {
            List<Asiento> asientos = obtenerAsientos();
            for (Asiento asiento : asientos) {
                if (asiento.getCodigo() == asientoNumero) {
                    if (asiento.getPasajero() != null) {
                        System.out.println("Datos del pasajero en el asiento " + asientoNumero + ": ");
                        System.out.println("Nombre: " + asiento.getPasajero().getNombre());
                        System.out.println("Apellido: " + asiento.getPasajero().getApellido());
                    } else {
                        System.out.println("El asiento " + asientoNumero + " no tiene un pasajero asignado.");
                    }
                    return;
                }
            }
            System.out.println("El asiento " + asientoNumero + " no existe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Asiento> obtenerAsientos() throws IOException {
        if (fichero.exists()) {
            return objectMapper.readValue(fichero, objectMapper.getTypeFactory().constructCollectionType(List.class, Asiento.class));
        } else {
            return new ArrayList<>();
        }
    }

    private static void guardarAsientos(List<Asiento> asientos) throws IOException {
        objectMapper.writeValue(fichero, asientos);
    }
}