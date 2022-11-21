package com.bjpn.service;

import com.bjpn.bean.User;

public interface UserService {
    User loginUserService(String userCode, String userPwd);
}
