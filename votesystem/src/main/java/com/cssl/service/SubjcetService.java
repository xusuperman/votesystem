package com.cssl.service;

import com.cssl.pojo.Subject;
import com.github.pagehelper.PageInfo;
import com.cssl.pojo.item;
import  com.cssl.pojo.choose;

import java.util.List;
import java.util.Map;

public interface SubjcetService {

    public List<Map<String,Object>> selectSubject(Map<String,Object> map);
    public Subject selectSubjectItemDetail(int sid);
    public List<choose> selectChooseBySubjectId(int sid);
    public List<item> selectItemBySubjectId(int sid);
    public int addSubject(Subject ss);
    public int deleteSubject(int sid);
    public int updateSubject(Map<String,Object> map);
}
