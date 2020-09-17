package com.yliu.elasticjob.Listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyListener implements ElasticJobListener {
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        //log.info("Listening -- before job executed do something");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        //log.info("Listening -- after job executed do something");
    }
}
