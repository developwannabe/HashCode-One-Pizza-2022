package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

    BufferedReader archivo = null;
    ArrayList<Cliente> clientes = null;
    ArrayList<String> ingredientes= new ArrayList<>();
    ArrayList<Integer> ratios = new ArrayList<>();

    public Input(String ruta) {
        try {
            archivo = new BufferedReader(new FileReader(ruta));
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado " + e);
            System.exit(0);
        }
    }

    public String siguiente() {
        String line;
        try {
            if ((line = archivo.readLine()) != null) {
                return line;
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Excepcion ocurrida" + e);
        }
        return null;
    }

    public void preferencias() {
        int nClientes = Integer.parseInt(siguiente());
        clientes = new ArrayList<>(nClientes);
        for (int i = 0; i < nClientes; i++) {
            clientes.add(new Cliente());
        }
        int actual = 2;
        String linea;
        int indCliente = -1;
        while ((linea = siguiente()) != null) {
            String[] x = linea.split(" ");
            int numero = Integer.parseInt(x[0]);
            if (actual%2==0) {
                indCliente++;
                clientes.get(indCliente).setFav(x);
            } else {
                clientes.get(indCliente).setNoFav(x);
            }
            if (numero > 0) {
                for (int i = 1; i <= numero; i++) {
                    if(!ingredientes.contains(x[i])){
                        ingredientes.add(x[i]);
                        ratios.add(0);
                    }
                    if(actual%2==0){
                        int aux = ratios.get(ingredientes.indexOf(x[i]));
                        aux++;
                        ratios.set(ingredientes.indexOf(x[i]),aux);
                    }else{
                        int aux = ratios.get(ingredientes.indexOf(x[i]));
                        aux--;
                        ratios.set(ingredientes.indexOf(x[i]),aux);
                    }
                }
            }
            actual++;
        }
    }

    public Pizza oidoCocina(){
        return new Horno(this.ingredientes, this.clientes, this.ratios).mejorPizza();
    }

}

