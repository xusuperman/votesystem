package com.cssl.controller;

import javafx.application.Application;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.cssl.vo.uservo;
import com.cssl.pojo.user;
import  com.cssl.service.userService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller


public class userController {

    @Autowired
    private userService uService;

    private List<String> userlist=new ArrayList<>();
    private user uu=new user();


    @RequestMapping("/denglu")
    public ModelAndView login(uservo uvo, ModelAndView model, HttpServletRequest request,HttpSession session) {

        user u1 = new user();
        BeanUtils.copyProperties(uvo, u1);


                 uu=uService.login(u1);
                 ServletContext application=request.getServletContext();
                 userlist=(List<String>) application.getAttribute("users");

                 if(userlist.contains(uu.getUsername())) {
                     model.addObject("userstate", "用户已经在线");
                     model.setViewName("login");

                 }  else {

                     if(uu!=null){

                         session.setAttribute("user", uu);
                         userlist.add(uu.getUsername());
                         application.setAttribute("users", userlist);
                         model.addObject("msg", "登陆成功!");
                         model.setViewName("forward:/selectSubject?pageIndex=1");
                     }else{
                         model.addObject("msg", "登陆失败!");
                     }
                 }
                return model;

    }

    @RequestMapping("/register")
    public ModelAndView register(uservo uvo, ModelAndView model) {

        user u1 = new user();
        BeanUtils.copyProperties(uvo, u1);

        if (uService.register(u1)==true){
            model.addObject("msg", "注册成功!");
            model.setViewName("login");
        } else {
            model.addObject("msg", "注册失败!");
            model.setViewName("regist");
        }
        return model;
    }
     @ResponseBody
     @RequestMapping("/selectNameInUser")
     public boolean selectNameInUser(uservo uvo) {


         user u1=new user();
         BeanUtils.copyProperties(uvo,u1);
         if (uService.selectNameInUser(u1)==true){
                 return true;
         } else {
             return false;

         }

     }


     @RequestMapping("/exit")
     public ModelAndView  exit(ModelAndView model, HttpSession session){

         session.invalidate();
         model.setViewName("login");
         return model;
     }







}
