package com.learning.java.simulate.registry;

import lombok.Data;

@Data
public class RegistryInfo {

    private Integer appID;

    private String address;

    public RegistryInfo(Integer appID, String address) {
        this.appID = appID;
        this.address = address;
    }

    public Integer getAppID() {
        return appID;
    }

    public String getAddress() {
        return address;
    }

}
