package com.p3solutions.archon_mongodb_persistence.controller;

import com.p3solutions.archon_mongodb_persistence.user.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
@Autowired
    UserMapperImpl userMapper;
@GetMapping("getvalue")
    public ResponseBean getDetails(){
        ResponseBean responseBean=ResponseBean.builder().data(userMapper.findAll()).build();

        return responseBean;
    }
}
