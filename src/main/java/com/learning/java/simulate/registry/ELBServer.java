package com.learning.java.simulate.registry;

import com.learning.java.simulate.app.AppEngine;
import com.learning.java.simulate.app.Request;
import com.learning.java.simulate.app.Response;
import com.learning.java.simulate.balance.LoadBalance;
import com.learning.java.simulate.balance.RandomBalance;
import com.learning.java.simulate.balance.RoundRobinBalance;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 1.when an app do init(), it will register itself to ELB
 * 2.when ann app do destroy(), it will cancel registration from ELB
 * 3.an app needs to keep its heartbeats to ELB at regular time, if not, ELB will remove the app
 * 4.an app can query the active server list from ELB to do the remote calling with each other
 */
public class ELBServer implements RegistryClient, ServiceClient {

    private List<RegistryInfo> registryInfoList = new ArrayList<>();

    private Map<Integer, RegistryInfo> registryInfoMap = new HashMap<>();

    private String loadBalanceRule;

    private LoadBalance loadBalance;

    public ELBServer(String loadBalanceRule) {
        this.loadBalanceRule = loadBalanceRule;
    }

    public void setLoadBalanceRule(String loadBalanceRule) {
        this.loadBalanceRule = loadBalanceRule;
    }

    @Override
    public boolean register(RegistryInfo registryInfo) {
        if (isValidRegistryInfo(registryInfo)) {
            registryInfoList.add(registryInfo);
            registryInfoMap.put(registryInfo.getAppID(), registryInfo);
            System.out.println("App of " + registryInfo.getAppID() + " registers itself successfully!");
            return true;
        } else {
            System.out.println("Register fails! Please check the registry info");
            return false;
        }
    }

    @Override
    public boolean cancelRegister(RegistryInfo registryInfo) {
        if (isValidRegistryInfo(registryInfo)) {
            registryInfoList.remove(registryInfo);
            registryInfoMap.remove(registryInfo.getAppID());
            return true;
        } else {
            System.out.println("Registration cancellation fails! Please check the registry info");
            return false;
        }
    }

    @Override
    public void onHeartBeat(Integer appID) {
        while (true) {
            registryInfoList.forEach(registryInfo -> {
                AppEngine app = new AppEngine(appID, AppEngine.ADDRESS_MAP.get(appID), this);
                if (!app.isAlive()) this.cancelRegister(registryInfo);
            });
            try {
                Thread.sleep(30 * 1000);
            } catch (Exception e) {
                System.out.println("Exception happens when sending heart beats to ELB " + e.getMessage());
            }
        }
    }

    @Override
    public Response service(Request request) {
        if (isValidServiceRequest(request)) {
            Integer appID;
            switch (loadBalanceRule) {
                case "RoundRobin": default:
                    System.out.println("Select Round Robin rules to do the load balancing");
                    loadBalance = new RoundRobinBalance();
                    break;
                case "Random":
                    System.out.println("Select Random rules to do the load balancing");
                    loadBalance = new RandomBalance();
                    break;
            }
            appID = loadBalance.doBalancing(Arrays.asList(1, 2));
            return callApp(request, appID);
        } else {
            return new Response("400", "request");
        }
    }

    private Response callApp(Request request, Integer appID) {
        /**
         * simulation and simplification
         * actually we need to call HTTP request according to the address of the app
         * */
        System.out.println("Forward the request to App: " + appID);
        Response response = new AppEngine(appID, AppEngine.ADDRESS_MAP.get(appID), this)
                .service(request);
        return response;
    }

    private boolean isValidRegistryInfo(RegistryInfo registryInfo) {
        return registryInfo != null && registryInfo.getAppID() != null
                && !StringUtils.isEmpty(registryInfo.getAddress());
    }

    private boolean isValidServiceRequest(Request request) {
        return request != null && request.getRequestID() != null;
    }

}
