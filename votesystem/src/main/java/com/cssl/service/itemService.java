package com.cssl.service;

import com.cssl.pojo.item;

import java.util.List;
import java.util.Map;

public interface itemService {

    public List<item> selecItemstBychooseId(int oid);
    public item selecItemstByUserId(int uid);
    public int insertItem(item ii);
    public int deleteitem(Map<String,Object> map);


}
