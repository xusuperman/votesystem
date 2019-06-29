package com.cssl.Listener;




import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttrListener implements HttpSessionAttributeListener{
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("attributeAdded:"+se.getName()+":"+se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("attributeremoveed:"+se.getName()+":"+se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
          System.out.println("before attributeReplaced:"+se.getName()+":"+se.getValue());
          HttpSession session=se.getSession();
          System.out.println("after attributedReplaced:"+se.getName()+":"+session.getAttribute(se.getName()));
    }
}
