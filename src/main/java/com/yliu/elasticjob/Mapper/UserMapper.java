package com.yliu.elasticjob.Mapper;

import com.yliu.elasticjob.Model.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Component
public interface UserMapper{
    int insert(User user);

    int update(int id, String name);

    List<User> getUsers(int sharding);
}
