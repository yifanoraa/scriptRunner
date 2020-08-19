package com.yliu.elasticjob.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yliu.elasticjob.Mapper.JobMapper;
import com.yliu.elasticjob.Model.JobScheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobMapper jobMapper;

    @Override
    public int addJob(JobScheduled jobScheduled) {
        return jobMapper.insert(jobScheduled);
    }

    @Override
    public int updateJob(int id, String name) {
        return jobMapper.update(id, name);
    }

    @Override
    public void deleteJob(JobScheduled jobScheduled) {
        jobMapper.deleteById(jobScheduled.getId());
    }

    @Override
    public List<JobScheduled> getData() {
        QueryWrapper<JobScheduled> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .last("limit 1")
                .orderByDesc("id");
        List<JobScheduled> jobScheduleds = new LinkedList<>();
        jobScheduleds.add(jobMapper.selectOne(queryWrapper));
        return jobScheduleds;
    }

}
