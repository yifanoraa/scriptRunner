package com.yliu.elasticjob.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yliu.elasticjob.Mapper.UserMapper;
import com.yliu.elasticjob.Model.JobScheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(JobScheduled jobScheduled) {
        return userMapper.insert(jobScheduled);
    }

    @Override
    public int updateUserName(int id, String name) {
        return userMapper.update(id, name);
    }

    @Override
    public void deleteUser(JobScheduled jobScheduled) {
        userMapper.deleteById(jobScheduled.getId());
    }

    @Override
    public List<JobScheduled> getData() {
        QueryWrapper<JobScheduled> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .last("limit 1")
                .orderByDesc("id");
        List<JobScheduled> jobScheduleds = new LinkedList<>();
        jobScheduleds.add(userMapper.selectOne(queryWrapper));
        return jobScheduleds;
    }

}
