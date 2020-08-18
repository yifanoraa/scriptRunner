package com.yliu.elasticjob.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yliu.elasticjob.Model.JobScheduled;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<JobScheduled> {

    int insert(JobScheduled jobScheduled);

    int update(int id, String name);

}
