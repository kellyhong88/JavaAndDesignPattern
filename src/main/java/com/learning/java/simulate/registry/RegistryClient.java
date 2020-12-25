package com.learning.java.simulate.registry;

/**
 * API for servers to do the registration related things
 * */
public interface RegistryClient {

    boolean register(RegistryInfo registryInfo);

    boolean cancelRegister(RegistryInfo registryInfo);

    void onHeartBeat(Integer appID);

}
