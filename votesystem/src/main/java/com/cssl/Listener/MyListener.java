package com.cssl.Listener;






import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.cssl.pojo.user;

import java.util.ArrayList;
import java.util.List;

@WebListener

public class MyListener implements ServletContextListener,HttpSessionListener{

     private ServletContext application;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       System.out.println("application初始化");
       application=sce.getServletContext();
       application.setAttribute("users",new ArrayList<String>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁。。。。。。");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        System.out.println("session创建:"+session.getId());
        session.setMaxInactiveInterval(3000);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        System.out.println("session销毁:"+session.getId());
        //注销
        user uu=(user)session.getAttribute("user");
        List<String> userlist=(List<String>) application.getAttribute("users");
        if(userlist.contains(uu.getUsername())){
            userlist.remove(uu.getUsername());
        }
    }
}
