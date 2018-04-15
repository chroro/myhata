package com.myhata.demo.user;

import com.myhata.demo.entitites.user.User;

public interface UserDao {

    User getUserById(Long id);
}
