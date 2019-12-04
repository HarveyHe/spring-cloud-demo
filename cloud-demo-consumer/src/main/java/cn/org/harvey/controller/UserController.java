package cn.org.harvey.controller;

import cn.org.harvey.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){
        log.info("ssssssss");
         return restTemplate.getForObject("http://provider-demo/user/getUser/"+id,User.class);
    }
}
