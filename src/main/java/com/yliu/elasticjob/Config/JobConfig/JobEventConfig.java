package com.yliu.elasticjob.Config.JobConfig;


import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class JobEventConfig {

    @Autowired
    @Qualifier("two")
    private DataSource dataSource;

    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }
}