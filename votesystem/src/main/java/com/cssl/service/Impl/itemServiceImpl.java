package com.cssl.service.Impl;
import com.cssl.pojo.item;
import  com.cssl.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cssl.pojo.item;
import  com.cssl.dao.itemDao;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class itemServiceImpl implements  itemService{

    @Autowired
   private itemDao idao;
    @Override
    public List<item> selecItemstBychooseId(int oid) {
        return idao.selecItemstBychooseId(oid);
    }

    @Override
    public item selecItemstByUserId(int uid) {
        return idao.selecItemstByUserId(uid);
    }

    @Override
    public int insertItem(item ii) {
        return idao.insertItem(ii);
    }

    @Override
    public int deleteitem(Map<String, Object> map) {
        return idao.deleteitem(map);
    }
}
