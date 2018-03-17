package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.RegisterfileUser;

public interface RegisterfileUserMapper {
    int deleteByPrimaryKey(String sequencenumber);

    int insert(RegisterfileUser record);

    int insertSelective(RegisterfileUser record);

    RegisterfileUser selectByPrimaryKey(String sequencenumber);

    int updateByPrimaryKeySelective(RegisterfileUser record);

    int updateByPrimaryKey(RegisterfileUser record);
}