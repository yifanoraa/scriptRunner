package com.yliu.elasticjob.Service;

import com.yliu.elasticjob.Model.JobScheduled;

import java.util.List;

public interface UserService {

    int addUser(JobScheduled jobScheduled);

    int updateUserName(int id, String name);

    void deleteUser(JobScheduled jobScheduled);

    List<JobScheduled> getData();
}

