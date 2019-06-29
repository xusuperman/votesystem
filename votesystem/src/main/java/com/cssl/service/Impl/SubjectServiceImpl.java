package com.cssl.service.Impl;

import com.cssl.dao.SubjectDao;
import com.cssl.pojo.Subject;
import com.cssl.pojo.choose;
import com.cssl.pojo.item;
import com.cssl.service.SubjcetService;
import com.sun.scenario.effect.impl.sw.sse.SSERendererDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SubjectServiceImpl implements SubjcetService{

    @Autowired
    private SubjectDao sdao;

    @Override
    public List<Map<String,Object>> selectSubject(Map<String,Object> map){

       return sdao.selectSubject(map);

    }

    @Override
    public Subject selectSubjectItemDetail(int sid) {

        return sdao.selectSubjectItemDetail(sid);
    }

    @Override
    public List<choose> selectChooseBySubjectId(int sid) {

        return  sdao.selectChooseBySubjectId(sid);
    }

    @Override
    public int updateSubject(Map<String, Object> map) {
        return sdao.updateSubject(map);
    }

    @Override
    public List<item> selectItemBySubjectId(int sid) {

       return sdao.selectItemBySubjectId(sid);
    }

    @Override
    public int addSubject(Subject ss) {
        return sdao.addSubject(ss);
    }

    @Override
    public int deleteSubject(int sid) {
        return sdao.deleteSubject(sid);
    }
}
