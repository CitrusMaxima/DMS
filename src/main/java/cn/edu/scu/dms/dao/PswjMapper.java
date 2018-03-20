package cn.edu.scu.dms.dao;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;

public interface PswjMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Pswj record);

    int insertSelective(Pswj record);

    Pswj selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Pswj record);

    int updateByPrimaryKey(Pswj record);
    
    List<Pswj> getAllFile();
}