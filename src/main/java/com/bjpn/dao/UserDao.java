package com.bjpn.dao;

import com.bjpn.bean.User;

public interface UserDao {
    User loginUser(String userCode, String userPwd);
}
