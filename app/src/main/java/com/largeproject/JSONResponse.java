package com.largeproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONResponse {

    @SerializedName("instances")
    private List<AddInstanceRequest> instances;

    public List<AddInstanceRequest> getInstances() {
        return instances;
    }

    public void setInstances(List<AddInstanceRequest> instances) {
        this.instances = instances;
    }
}
