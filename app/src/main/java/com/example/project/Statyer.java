package com.example.project;

import android.util.Log;

class Statyer {

    private String name;
    private String location;
    private int size;

    public Statyer(String name, String location, int size) {

        this.name = name;
        this.location = location;
        this.size = size;
    }

    public String toString() {
        String tmp = "Name: "+name + " Location: " + location + " Size: " +  size +" Meters" ;

        return tmp;
    }
}