package com.example.project;

import android.util.Log;

class Mountain {

    private String name;
    private String location;
    private int size;

    public Mountain(String name, String location, int size) {

        this.name = name;
        this.location = location;
        this.size = size;
    }

    public String toString() {
        String tmp = name + " " + location + " " + size;

        return tmp;
    }
}