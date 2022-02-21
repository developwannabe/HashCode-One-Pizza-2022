package com.company;


public class Pizzeria {
    public static void main(String[] args) {
        String [] archivos = {/*"a_an_example.in.txt",
                "b_basic.in.txt",
                "c_coarse.in.txt",
                "d_difficult.in.txt",*/
                "e_elaborate.in.txt"};
        for (String linea:archivos) {
            System.out.println("Leyendo resultados de la encuestra...");
            Input datos = new Input("input/"+linea);
            System.out.println("Leido con exito \n Cargando gustos...");
            datos.preferencias();
            System.out.println("¡Gustos apuntados! \n Realizando Pizzas");
            Pizza ganadora = datos.oidoCocina();
            System.out.println("La mejor pizza es " + ganadora.toString() + "\n");
            Output output = new Output(ganadora,linea);
        }
    }

}
