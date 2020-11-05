package com.cl.demo.service;

import com.cl.demo.entity.User;

/**
 * @author cl
 * @description 用户业务接口
 */
public interface UserService {
    /**
     *
     * @param user 用户对象
     * @return 成功则返回"success"，失败则返回错误信息
     */
    String addUser(User user);
}
