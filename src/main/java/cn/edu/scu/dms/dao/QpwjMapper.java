package cn.edu.scu.dms.dao;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.model.Qpwj;

public interface QpwjMapper {
    int deleteByPrimaryKey(String qpid);

    int insert(Qpwj record);

    int insertSelective(Qpwj record);
    List<Qpwj> getAllFile();
    Qpwj selectByPrimaryKey(String qpid);

    int updateByPrimaryKeySelective(Qpwj record);

    int updateByPrimaryKey(Qpwj record);
}