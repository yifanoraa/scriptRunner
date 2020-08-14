package com.yliu.elasticjob.Job;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SpringSimpleJob implements SimpleJob {

    private static AtomicInteger count = new AtomicInteger(0);


    /**
     * Simple Job
     *
     * @param shardingContext
     */
    @Override
    public void execute(final ShardingContext shardingContext) {

        log.info("Total job count: {}, current shard: {}", shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem());
    }
}