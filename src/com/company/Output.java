package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Output {

    public String frase;
    public String direccion;

    public Output(Pizza pizza,String linea){
        this.frase= pizza.toString();
        this.direccion=linea;
        this.escribir();
    }

    public void escribir() {
        try {
            FileWriter escritura = new FileWriter("salida/"+direccion);
            escritura.write(frase);
            escritura.close();
            System.out.println("Se ha finalizado la escritura");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}







