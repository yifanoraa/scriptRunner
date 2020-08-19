package com.yliu.elasticjob.Service;

import com.yliu.elasticjob.Model.JobScheduled;

import java.util.List;

public interface JobService {

    int addJob(JobScheduled jobScheduled);

    int updateJob(int id, String name);

    void deleteJob(JobScheduled jobScheduled);

    List<JobScheduled> getData();
}

