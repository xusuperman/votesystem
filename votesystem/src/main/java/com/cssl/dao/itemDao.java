package com.cssl.dao;

import java.util.List;
import java.util.Map;
import com.cssl.SupperMapper;
import com.cssl.pojo.choose;
import  com.cssl.pojo.item;
public interface itemDao extends  SupperMapper<choose>{

    public List<item> selecItemstBychooseId(int oid);
    public item selecItemstByUserId(int uid);
    public int insertItem(item ii);
    public int deleteitem(Map<String,Object> map);
}
