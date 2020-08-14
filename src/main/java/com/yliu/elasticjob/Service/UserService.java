package com.yliu.elasticjob.Service;

import com.yliu.elasticjob.Model.User;
import java.util.List;

public interface UserService {

    int addUser(User user);

    int updateUserName(int id, String name);

    List<User> getDataBySharding(int shardNum);
}

