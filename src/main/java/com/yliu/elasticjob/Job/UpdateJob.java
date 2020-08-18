package com.yliu.elasticjob.Job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.yliu.elasticjob.Dynamic.AddNewJob;
import com.yliu.elasticjob.Model.JobScheduled;
import com.yliu.elasticjob.Service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;


@Slf4j
public class UpdateJob implements DataflowJob<JobScheduled> {
    @Autowired
    UserService userService;
    @Autowired
    AddNewJob addNewJob;

    @Override
    public List<JobScheduled> fetchData(ShardingContext shardingContext) {
        log.info("Fetch data", shardingContext.getShardingItem());

        switch (shardingContext.getShardingItem()) {
            case 0:
                return  userService.getData();
//            case 1:
//                return userService.getDataBySharding(1);
        }
        return new LinkedList<JobScheduled>();
    }


    @Override
    @SneakyThrows
    synchronized public void processData(ShardingContext shardingContext, List<JobScheduled> data) {
        for(JobScheduled jobScheduled : data){
            if(jobScheduled == null){
                return;
            }
//            log.info("Job name: {}",user.getName());
            addNewJob.addJob(jobScheduled.getName(),
                    (SimpleJob) Class.forName("com.yliu.elasticjob.Job." + jobScheduled.getName()).newInstance(),
                    jobScheduled.getCron(),
                    1, "1=one");
            userService.deleteUser(jobScheduled);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
