package com.largeproject;

import java.util.ArrayList;

public class Teams {

    private String name;
    private ArrayList<Machines> machines = new ArrayList<Machines>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Machines> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machines> machines) {
        this.machines = machines;
    }
}
