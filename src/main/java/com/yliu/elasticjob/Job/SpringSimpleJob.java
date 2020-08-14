package com.yliu.elasticjob.Job;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.yliu.elasticjob.Model.User;
import com.yliu.elasticjob.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SpringSimpleJob implements SimpleJob {

    @Autowired
    UserService userService;

    public static int userCount = 1;

    @Override
    public void execute(final ShardingContext shardingContext) {
        User newUser = new User();
        userCount += 1;
        newUser.setName(String.valueOf(userCount));
        userService.addUser(newUser);
        log.info("New user added ");
        log.info(String.format("------Thread ID: %s, Total Job count: %s, Current Shard: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
    }
}