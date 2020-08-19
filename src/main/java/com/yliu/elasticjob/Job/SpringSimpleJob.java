package com.yliu.elasticjob.Job;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SpringSimpleJob implements com.dangdang.ddframe.job.api.simple.SimpleJob {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void execute(final ShardingContext shardingContext) {
        log.info("Doing Simple Job!!");
    }
}