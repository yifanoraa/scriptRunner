package com.yliu.elasticjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yliu.elasticjob.Mapper")
public class ElasticjobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticjobApplication.class, args);
    }

}
