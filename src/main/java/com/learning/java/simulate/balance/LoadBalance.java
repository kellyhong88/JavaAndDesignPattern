package com.learning.java.simulate.balance;

import java.util.List;

/**
 * interface of load balance rules
 * using Strategic Pattern
 * */
public interface LoadBalance {

    /**
     * return the selected appID after load balancing
     * */
    Integer doBalancing(List<Integer> appIDList);

}
