package com.cl.demo.service.impl;

import com.cl.demo.entity.User;
import com.cl.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author cl
 * @description 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String addUser(User user) {
        // 直接编写业务逻辑
        return "success";
    }
}
