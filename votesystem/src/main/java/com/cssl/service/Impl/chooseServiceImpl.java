package com.cssl.service.Impl;
import com.cssl.pojo.choose;
import com.cssl.pojo.item;
import  com.cssl.service.chooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import  com.cssl.dao.chooseDao;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class chooseServiceImpl implements chooseService{
    @Autowired
    private chooseDao cdao;
    @Override
    public List<choose> selectChooseBySubjectId(int sid) {
        return cdao.selectChooseBySubjectId(sid);
    }

    @Override
    public List<choose> selectAllItemsNumberDetailBySid(int sid) {
        return cdao.selectAllItemsNumberDetailBySid(sid);
    }

    @Override
    public int addChoose(choose cc) {
        return cdao.addChoose(cc);
    }

    @Override
    public int deleteChoose(int oid) {
        return cdao.deleteChoose(oid);
    }

    @Override
    public int updateChoose(Map<String, Object> map) {
        return cdao.updateChoose(map);
    }

    @Override
    public int insertChoose(choose cc) {
        return cdao.insertChoose(cc);
    }
}
