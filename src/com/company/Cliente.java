package com.company;

import java.util.ArrayList;

public class Cliente {

    ArrayList<String> fav =new ArrayList<>();
    ArrayList<String> noFav =new ArrayList<>();

    public Cliente() {}

    public void setFav(String[] fav) {
        if(fav.length>1){
            for(int i = 1; i<fav.length;i++){
                this.fav.add(fav[i]);
            }
        }
    }

    public void setNoFav(String[] noFav) {
        if(noFav.length>1){
            for(int i = 1; i<noFav.length;i++){
                this.noFav.add(noFav[i]);
            }
        }
    }

    public boolean meGustaria(ArrayList<String> ingredientes){
        boolean meGusta = true;
        for(String i : fav){
            if(!ingredientes.contains(i)){
                return false;
            }
        }
        for(String i : noFav){
            if(ingredientes.contains(i)){
                return false;
            }
        }
        return meGusta;
    }

}
