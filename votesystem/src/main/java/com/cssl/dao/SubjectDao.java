package com.cssl.dao;

import com.cssl.pojo.Subject;
import  com.cssl.pojo.item;
import com.cssl.pojo.choose;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SubjectDao {

    public List<Map<String,Object>> selectSubject(Map<String,Object> map);
    public Subject selectSubjectItemDetail(int sid);
    public List<choose>  selectChooseBySubjectId(int sid);
    public List<item>  selectItemBySubjectId(int sid);
    public int addSubject(Subject ss);
    public int deleteSubject(int sid);
    public int updateSubject(Map<String,Object> map);
}
