package com.cssl.service.Impl;


import com.cssl.pojo.user;
import  com.cssl.service.userService;
import  com.cssl.dao.userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class userServiceImpl implements  userService{

    @Autowired
    private userdao udao;
    @Override
    public user login(user uu) {

         return udao.login(uu);
    }

    @Override
    public boolean register(user uu) {
          if(udao.register(uu)>0){
              return true;

          }
          return false;

    }

    @Override
    public boolean selectNameInUser(user uu) {
          if(udao.selectNameInUser(uu)>0){
              return true;
          }
          return false;
    }
}
