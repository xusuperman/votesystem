package com.cssl.dao;

import com.cssl.SupperMapper;
import java.util.List;
import java.util.Map;
import  com.cssl.pojo.choose;
import com.cssl.pojo.item;

public interface chooseDao extends SupperMapper<choose>{

    public List<choose> selectChooseBySubjectId(int osid);
    public List<choose> selectAllItemsNumberDetailBySid(int osid);
    public int addChoose(choose cc);
    public int deleteChoose(int oid);
    public int updateChoose(Map<String,Object>  map);
    public int insertChoose(choose cc);
}
