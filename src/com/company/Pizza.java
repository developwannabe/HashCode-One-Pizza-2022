package com.company;

import java.util.ArrayList;

public class Pizza {

    ArrayList<String> ingredientes;
    int valoracion;

    public Pizza(ArrayList<String> ingredientes, int valoracion) {
        this.ingredientes = ingredientes;
        this.valoracion = valoracion;
    }

    public String toString() {
        int tam = ingredientes.size();
        String y = new String(tam + " ");
        for (int i = 0; i < tam-1; i++) {
            y = y.concat(ingredientes.get(i)+" ");
        }
        y=y+ingredientes.get(tam-1);
        return y;
    }


}
