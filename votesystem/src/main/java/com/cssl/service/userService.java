package com.cssl.service;

import com.cssl.pojo.user;
public interface userService {
    public user login(user uu);
    public boolean register(user uu);
    public boolean selectNameInUser(user uu);
}
