package com.cssl.dao;

import java.util.List;
import com.cssl.pojo.user;

public interface userdao {

    public user login(user uu);
    public int register(user uu);
    public int selectNameInUser(user uu);
}
