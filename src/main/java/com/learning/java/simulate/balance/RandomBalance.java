package com.learning.java.simulate.balance;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * adopted Random rules to do the balancing
 */
public class RandomBalance implements LoadBalance {

    @Override
    public Integer doBalancing(List<Integer> appIDList) {
        if (CollectionUtils.isEmpty(appIDList)) return 0;
        return appIDList.get(1);
    }

}
