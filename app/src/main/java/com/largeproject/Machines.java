package com.largeproject;

import java.util.ArrayList;

public class Machines {
    private String name;
    private String ip;
    public ArrayList<Services> services = new ArrayList<Services>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ArrayList<Services> getServices() {
        return services;
    }

    public void setServices(ArrayList<Services> services) {
        this.services = services;
    }
}
