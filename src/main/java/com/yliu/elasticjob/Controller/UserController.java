package com.yliu.elasticjob.Controller;

import com.yliu.elasticjob.Model.JobScheduled;
import com.yliu.elasticjob.Service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    JobService service;


    @PostMapping("/add")
    public void addNewUser(@RequestBody JobScheduled jobScheduled){
        log.info("Got user parameter: {}", jobScheduled.getName());
        service.addJob(jobScheduled);

    }


    @PostMapping("/update")
    public void addNewUser(@RequestParam(name = "id", required = true)
                                       int id,
                           @RequestParam(name = "name", required = true)
                                       String name){
        log.info("Got user parameter: {} : {}", id, name);
        service.updateJob(id, name);

    }

    @GetMapping("/byshard")
    public List<JobScheduled> fetchUser(@RequestParam(name = "shardNum", required = true)
                                            int shardNum){
        log.info("Got shard number: {}", shardNum);
        List<JobScheduled> dataFetched = service.getData();
        return dataFetched;
    }
}
