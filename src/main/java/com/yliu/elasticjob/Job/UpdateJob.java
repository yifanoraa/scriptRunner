package com.yliu.elasticjob.Job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.yliu.elasticjob.Model.User;
import com.yliu.elasticjob.Service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class UpdateJob implements DataflowJob<User> {
    @Autowired
    UserService userService;

    @Override
    public List<User> fetchData(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                return userService.getDataBySharding(0);
            case 1:
                return userService.getDataBySharding(1);
        }
        return null;
    }

    @SneakyThrows
    @Override
    synchronized public void processData(ShardingContext shardingContext, List<User> data) {
        log.info("<========= In shard {} with parameter {} ==========>", shardingContext.getShardingItem() , shardingContext.getShardingParameter());

        for(User user: data){
            log.info("User name: {}",user.getName());
        }
        Thread.sleep(5000);

    }
}
