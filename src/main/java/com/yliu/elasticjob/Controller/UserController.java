package com.yliu.elasticjob.Controller;

import com.yliu.elasticjob.Model.User;
import com.yliu.elasticjob.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService service;


    @PostMapping("/add")
    public void addNewUser(@RequestBody User user){
        log.info("Got user parameter: {}", user.getName());
        service.addUser(user);

    }


    @PostMapping("/update")
    public void addNewUser(@RequestParam(name = "id", required = true)
                                       int id,
                           @RequestParam(name = "name", required = true)
                                       String name){
        log.info("Got user parameter: {} : {}", id, name);
        service.updateUserName(id, name);

    }

    @GetMapping("/byshard")
    public List<User> fetchUser(@RequestParam(name = "shardNum", required = true)
                                            int shardNum){
        log.info("Got shard number: {}", shardNum);
        List<User> dataFetched = service.getDataBySharding(shardNum);
        return dataFetched;
    }
}
