package com.learning.java.simulate.registry;

import com.learning.java.simulate.app.Request;

/**
 * simulate the whole procedure of server's preparing works and client's sending requests
 * */
public class SimulateBoard {

    public static void main(String[] args) {
        ELBServer elbServer = new ELBServer("RoundRobin");
        Request request1 = new Request(1);
        elbServer.service(request1);

        elbServer.setLoadBalanceRule("Random");
        Request request2 = new Request(2);
        elbServer.service(request2);
    }

}
