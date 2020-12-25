package com.learning.java.simulate.balance;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * adopted Round Robin rules to do the balancing
 */
public class RoundRobinBalance implements LoadBalance {

    @Override
    public Integer doBalancing(List<Integer> appIDList) {
        if (CollectionUtils.isEmpty(appIDList)) return 0;
        return appIDList.get(0);
    }

}
