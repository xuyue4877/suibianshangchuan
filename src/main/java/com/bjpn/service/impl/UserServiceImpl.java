package com.bjpn.service.impl;

import com.bjpn.bean.User;
import com.bjpn.dao.UserDao;
import com.bjpn.dao.impl.UserDaoImpl;
import com.bjpn.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User loginUserService(String userCode, String userPwd) {
        User user = userDao.loginUser(userCode, userPwd);
        return user;
    }
}
