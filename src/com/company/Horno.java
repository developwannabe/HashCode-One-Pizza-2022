package com.company;

import java.util.ArrayList;

public class Horno {

    ArrayList<String> ingredientes;
    ArrayList <Cliente> clientes;
    ArrayList <Integer> ratios;

    public Horno (ArrayList<String> ingredientes, ArrayList<Cliente> clientes, ArrayList<Integer> ratios) {
        this.ingredientes = ingredientes;
        this.clientes=clientes;
        this.ratios=ratios;
    }

    public Pizza mejorPizza() {
        ArrayList<String> ordenados = new ArrayList<>();
        ArrayList<String> mejoresIngredientes=null;

        int mejor,mejorValoracion=-1;
        while (!ingredientes.isEmpty()) {
            mejor = mayor(ratios);
            ordenados.add(ingredientes.get(mejor));
            ingredientes.remove(mejor);
            ratios.remove(mejor);
        }
        int puntuacion;
        ArrayList<String> ingredientesAux = new ArrayList<>();
        for (String ing : ordenados) {
            ingredientesAux.add(ing);
            puntuacion= 0;
            for (Cliente c : clientes) {
                if (c.meGustaria(ingredientesAux)) {
                    puntuacion++;
                }
            }
            if(puntuacion>mejorValoracion){
                mejorValoracion=puntuacion;
                mejoresIngredientes=(ArrayList<String>)ingredientesAux.clone();
            }
        }
        return new Pizza(mejoresIngredientes,mejorValoracion);
    }

    public int mayor (ArrayList<Integer>list){
        int mayor=Integer.MIN_VALUE,contador=0,indM=0;
        for(Integer ind:list){
            if(ind>mayor){
                indM=contador;
                mayor=ind;
            }
            contador++;
        }
        return indM;
    }

}
