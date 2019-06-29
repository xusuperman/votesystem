package com.cssl.service;

import java.util.List;
import java.util.Map;

import com.cssl.pojo.choose;
import com.cssl.pojo.item;

public interface chooseService {
    public List<choose> selectChooseBySubjectId(int sid);
    public List<choose> selectAllItemsNumberDetailBySid(int sid);
    public int addChoose(choose cc);
    public int deleteChoose(int oid);
    public int updateChoose(Map<String,Object> map);
    public int insertChoose(choose cc);

}
