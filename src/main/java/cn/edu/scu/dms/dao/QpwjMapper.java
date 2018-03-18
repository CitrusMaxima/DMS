package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Qpwj;

public interface QpwjMapper {
    int deleteByPrimaryKey(String qpid);

    int insert(Qpwj record);

    int insertSelective(Qpwj record);

    Qpwj selectByPrimaryKey(String qpid);

    int updateByPrimaryKeySelective(Qpwj record);

    int updateByPrimaryKey(Qpwj record);
}