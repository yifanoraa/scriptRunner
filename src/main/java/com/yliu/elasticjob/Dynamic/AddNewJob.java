package com.yliu.elasticjob.Dynamic;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddNewJob {

    @Resource
    private ZookeeperRegistryCenter regCenter;


    public void addJob(final String jobName, final SimpleJob simpleJob, final String cron,
                       final int shardingTotalCount, final String shardingItemParameters) {
        simpleJobScheduler(jobName, simpleJob, cron, shardingTotalCount, shardingItemParameters).init();
    }


    public JobScheduler simpleJobScheduler(final String jobName, final SimpleJob simpleJob, final String cron,
                                           final int shardingTotalCount, final String shardingItemParameters) {
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(jobName, simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters);
        return new SpringJobScheduler(simpleJob, regCenter, liteJobConfiguration );
    }

    private LiteJobConfiguration getLiteJobConfiguration(final String jobName, final Class<? extends SimpleJob> jobClass,
                                                         final String cron, final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(
                jobName, cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build();
        // Simple job
        JobTypeConfiguration jobTypeConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());

        return LiteJobConfiguration.newBuilder(jobTypeConfiguration).overwrite(true).build();

    }
}