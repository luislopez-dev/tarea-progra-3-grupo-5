package org.example.controller;

import org.example.model.Persona;
import org.example.repository.AsientoRepository;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class BusController {

    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void showMenu() throws IOException {

        int menu_option;

        System.out.println("*****************************");
        System.out.println("*********** Menu ************");
        System.out.println("*****************************");
        System.out.println("1...... Registrar pasajero");
        System.out.println("2...... Ver disponibilidad de un asiento");
        System.out.println("3...... Ver información de un pasajero");
        System.out.println("4...... Ver si un asiento esta del lado de la ventana o del pasillo");
        System.out.println("INGRESE UNA OPCIÓN: ");

        menu_option = scanner.nextInt();

        switch (menu_option){
            case 1:
                registrarPasajeroMenu();
            case 2:
                verificarAsientoDisponibilidadMenu();
            case 3:
                verPasajeroInformacionMenu();
            case 4:
                verAsientoUbicacionMenu();
            default:
                showErrorMessage();
        }
    }

    private static void registrarPasajeroMenu() throws IOException {

        var pasajero = new Persona();

        System.out.println("INGRESE EL CÓDIGO DEL ASIENTO: ");

        var asientoCodigo = scanner.nextInt();

        pasajero.setNombre(scanner.next());

        System.out.println("INGRESE EL NOMBRE DEL PASAJERO: ");

        pasajero.setNombre(scanner.next());

        System.out.println("INGRESE EL APELLIDO DEL PASAJERO: ");

        pasajero.setApellido(scanner.next());

        AsientoRepository.RegistrarPasajero(pasajero, asientoCodigo);

        salirMenu();
    }

    private static void verificarAsientoDisponibilidadMenu() throws IOException {

        System.out.println("INGRESE EL CÓDIGO DE ASIENTO: ");

        int asientoNumero = scanner.nextInt();

        AsientoRepository.VerificarAsientoDisponibilidad(asientoNumero);

        salirMenu();
    }

    private static void verPasajeroInformacionMenu() throws IOException {

        System.out.println("INGRESE EL CÓDIGO DE ASIENTO: ");

        int asientoNumero = scanner.nextInt();

        AsientoRepository.verDatosPasajero(asientoNumero);

        salirMenu();
    }

    private static void verAsientoUbicacionMenu() throws IOException {

        System.out.println("INGRESE EL CÓDIGO DE ASIENTO: ");

        int asientoNumero = scanner.nextInt();

        AsientoRepository.verAsientoUbicacion(asientoNumero);

        salirMenu();
    }

    private static void showErrorMessage() throws IOException {

        System.out.println("ERROR: INGRESE UNA OPCIÓN CORRECTA!");

        System.exit(0);

        salirMenu();
    }

    private static void salirMenu() throws IOException {

        System.out.println("¿DESEA CONTINUAR (SI / NO): ?");

        var respuesta = scanner.next();

        if (Objects.equals(respuesta, "si")) {

            showMenu();
        } else {

            System.exit(0);
        }
    }
}
