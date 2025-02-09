package org.example;

import org.example.config.DbConfig;
import org.example.controller.BusController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DbConfig.generarArchivoInicial("fichero.json");

        BusController.showMenu();
    }
}