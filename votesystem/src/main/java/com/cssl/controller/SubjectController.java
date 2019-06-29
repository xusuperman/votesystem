package com.cssl.controller;

import com.cssl.pojo.Subject;
import com.cssl.service.SubjcetService;
import com.cssl.vo.Subjectvo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cssl.pojo.choose;
import com.sun.javafx.css.CssError;
import com.sun.scenario.effect.impl.sw.sse.SSERendererDelegate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEventHttpMessageReader;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import  com.cssl.service.chooseService;
import java.util.*;
import com.cssl.vo.chooseVo;
import  com.cssl.vo.itemvo;
import  com.cssl.pojo.item;
import  com.cssl.service.itemService;
import com.cssl.pojo.user;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(names = {"chooses","subjectItem"})
public class SubjectController {

    @Autowired
    private SubjcetService sService;
    @Autowired
    private itemService iService;
    @Autowired
    private chooseService cService;

    @RequestMapping("/selectSubject")
    public ModelAndView selectSubject(ModelAndView model, @RequestParam Map<String, Object> map, @RequestParam(defaultValue = "1") int pageIndex) {

        PageHelper.startPage(pageIndex, 3);
        List<Map<String, Object>> list = sService.selectSubject(map);
        PageInfo<Map<String, Object>> pInfo = new PageInfo<Map<String, Object>>(list);
        model.addObject("subjects", pInfo);
        if (map.get("wheretitle") != null) {
            model.addObject("titleCondition", map.get("wheretitle").toString());
        }
        model.setViewName("votelist");
        return model;
    }

    @RequestMapping("/selectVote")
    public ModelAndView goVote(ModelAndView model, Subjectvo svo, HttpSession session) {

        //判断是否投过票
        boolean istoupiao = false;
        //获取当前sessin中的用户对象
        user u = (user) session.getAttribute("user");
        //主题的所有选项.....
        List<choose> chooselist = sService.selectChooseBySubjectId(svo.getSid());
        //主题投票详情。。。
        Subject subjectItemDetail = sService.selectSubjectItemDetail(svo.getSid());
        //查询主题下所有的投票集合
        List<item> itemlist = sService.selectItemBySubjectId(svo.getSid());
        for (item i : itemlist) {
            if (i.getUid() == u.getUid()) {
                istoupiao = true;
                break;
            }
        }
        if (istoupiao == false) {

            model.addObject("SubjectItemDetail", subjectItemDetail);
            model.addObject("SubjectChooses", chooselist);

            model.setViewName("vote");

        } else {
            model.setViewName("forward:/selectVoteView?sid=" + svo.getSid());
        }
        return model;
    }

    @RequestMapping("/selectVoteView")
    public ModelAndView gotVoteView(ModelAndView model, Subjectvo cvo) {
        List<choose> list = cService.selectAllItemsNumberDetailBySid(cvo.getSid());
        Subject ss = sService.selectSubjectItemDetail(cvo.getSid());
        model.addObject("choosedetail", list);
        model.addObject("subject", ss);
        model.setViewName("voteview");
        return model;
    }

    @RequestMapping("/insertVote")
    public ModelAndView insertVote(itemvo ivo, ModelAndView model, HttpSession session) {

        System.out.println("sid:" + ivo.getSid());
        System.out.println("oid:" + ivo.getOidarray().size());
        user u = (user) session.getAttribute("user");
        item i = new item();
        BeanUtils.copyProperties(ivo, i);
        i.setUid(u.getUid());
        int state = iService.insertItem(i);
        if (state > 0) {
            model.addObject("msg", "投票成功!");
            model.setViewName("forward:/selectSubject?pageIndex=1");
        } else {
            model.addObject("msg", "投票失败!");
            model.setViewName("vote");
        }
        return model;
    }

    @RequestMapping("/selectWeiHuSubject")
    public ModelAndView selectWeiHuSubject(ModelAndView model, @RequestParam Map<String, Object> map, @RequestParam(defaultValue = "1") int pageIndex) {

        PageHelper.startPage(pageIndex, 3);
        List<Map<String, Object>> list = sService.selectSubject(map);
        PageInfo<Map<String, Object>> pInfo = new PageInfo<Map<String, Object>>(list);
        model.addObject("subjects", pInfo);
        if (map.get("wheretitle") != null) {
            model.addObject("titleCondition", map.get("wheretitle").toString());
        }
        model.setViewName("vote_modify.html");
        return model;
    }

    @RequestMapping("/addSubject")
    public ModelAndView goWeiHu(ModelAndView model, Subject svo, chooseVo cvo) {
        Subject s = new Subject();
        choose c = new choose();
        BeanUtils.copyProperties(svo, s);
        BeanUtils.copyProperties(cvo, c);
        int resultSubject = sService.addSubject(s);
        if (resultSubject > 0) {
            c.setOsid(s.getSid());
            int resultChoose = cService.addChoose(c);
            if (resultChoose > 0) {
                model.addObject("msg", "添加成功!");
                model.setViewName("forward:/selectSubject?pageIndex=1");
            } else {
                model.addObject("msg", "添加失败!");
                model.setViewName("add");
            }

        }

        return model;
    }

    @RequestMapping("/gomodify")
    public ModelAndView gomodify(ModelAndView model, int sid) {

        List<choose> chooselist = sService.selectChooseBySubjectId(sid);
        Subject ss = sService.selectSubjectItemDetail(sid);
        model.addObject("chooses", chooselist);
        System.out.println("choose size:" + chooselist.size());
        model.addObject("subjectItem", ss);
        System.out.println("subject :" + ss);
        model.setViewName("modify");
        return model;
    }

    @RequestMapping("/goadd")
    public ModelAndView goadd(ModelAndView model) {

        model.setViewName("add");
        return model;
    }


    @RequestMapping("/deleteSubject")
    public ModelAndView deleteSubject(ModelAndView model, int sid) {
        Map<String,Object> map=new HashMap<>();
        int resultSubject = sService.deleteSubject(sid);
        if (resultSubject > 0) {
            int resultChoose = cService.deleteChoose(sid);
            if (resultChoose > 0) {
                map.put("sid",sid);
                int resultItem = iService.deleteitem(map);
                if (resultItem > 0) {
                    model.addObject("msg", "删除成功!");
                } else {
                    model.addObject("msg", "删除失败!");
                }
                model.setViewName("forward:/selectWeiHuSubject");
            }
        }
        return model;
    }

    @RequestMapping("/weihu")
    public ModelAndView weihu(ModelAndView model, HttpSession session, @RequestParam  Map<String, Object> map,chooseVo cvo) {


       //原来的Subject.
        Subject ss = (Subject) session.getAttribute("subjectItem");
        choose c=new choose();
        //给Map指定的sid
        map.put("sid",ss.getSid());
        map.put("osid",ss.getSid());
        //原来的选项。
        List<choose> chooselist = (List<choose>) session.getAttribute("chooses");
        //新增


      if(cvo.getContentlist().size()!=0){


              c.setContentlist(cvo.getContentlist());
              c.setOsid(ss.getSid());
              cService.addChoose(c);
          }


        //修改主题表
        if (map.get("title") != null && map.get("type") != null) {

            sService.updateSubject(map);
            System.out.println("updateSubject:"+ sService.updateSubject(map));
        }
        //修改选项表
        for(int i = 0; i < chooselist.size(); i++) {
            if(i<=1) {
                map.put("oid",chooselist.get(i).getOid());
                map.put("content",map.get("content" + i));
                cService.updateChoose(map);
            }else {
                    //判断删除了哪些
                if (map.get("content" + i) == null) {
                     map.put("oid",chooselist.get(i).getOid());
                    cService.deleteChoose(chooselist.get(i).getOid());
                    iService.deleteitem(map);
                    System.out.println("deletechoose:"+ cService.deleteChoose(chooselist.get(i).getOid()));
                }else {
                    map.put("oid",chooselist.get(i).getOid());
                    map.put("content",map.get("content" + i));
                    //修改
                    cService.updateChoose(map);
                    System.out.println("updateChoose:"+cService.updateChoose(map));
                }
        }
        }
        model.setViewName("forward:/selectWeiHuSubject");
        return model;



}











}
