package com.yliu.elasticjob.Service;

import com.yliu.elasticjob.Mapper.UserMapper;
import com.yliu.elasticjob.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUserName(int id, String name) {
        return userMapper.update(id, name);
    }

    @Override
    public List<User> getDataBySharding(int shardNum) {
        return userMapper.getUsers(shardNum);
    }

}
