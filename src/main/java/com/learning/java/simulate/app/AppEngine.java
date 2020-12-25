package com.learning.java.simulate.app;

import com.learning.java.simulate.registry.RegistryClient;
import com.learning.java.simulate.registry.RegistryInfo;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * app server
 * 1. when it do init(), app need to register itself to ELB
 * 2. when it do destroy(), app need to cancel registration to ELB
 * 3. when it do service(), handle
 */
@Data
public class AppEngine {

    private RegistryClient registryClient;

    /**
     * Unique ID of one app
     */
    private Integer appID;

    private String address;

    public AppEngine(Integer appID, String address, RegistryClient registryClient) {
        this.appID = appID;
        this.address = address;
        this.registryClient = registryClient;
        init();
    }

    /**
     * simulation and simplification
     * actually we need to send a HTTP request according to the address of an app
     */
    public static Map<Integer, String> ADDRESS_MAP = new HashMap<Integer, String>() {{
        put(1, "ADDRESS_1");
        put(2, "ADDRESS_2");
    }};

    public boolean init() {
        System.out.println("Init a new app: " + appID);
        registryClient.register(new RegistryInfo(appID, address));
        return true;
    }

    public Response service(Request request) {
        try {
            System.out.println("Request: " + request.getRequestID() + " has been handled successfully!");
            return new Response("200", "Response message of request: " + request.getRequestID());
        } catch (Exception e) {
            return new Response("500", "Exception happens: " + e.getMessage());
        }
    }

    public boolean destroy() {
        System.out.println("Destroy the app: " + appID);
        registryClient.cancelRegister(new RegistryInfo(appID, address));
        return true;
    }

    public boolean isAlive() {
        return true;
    }

}
