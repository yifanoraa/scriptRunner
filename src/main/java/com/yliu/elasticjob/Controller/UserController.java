package com.yliu.elasticjob.Controller;

import com.yliu.elasticjob.Model.User;
import com.yliu.elasticjob.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
