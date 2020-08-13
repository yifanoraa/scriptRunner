package com.yliu.elasticjob.Mapper;

import com.yliu.elasticjob.Model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper{
    int insert(User user);
}
