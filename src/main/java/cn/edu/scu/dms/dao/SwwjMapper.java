package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Swwj;

public interface SwwjMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Swwj record);

    int insertSelective(Swwj record);

    Swwj selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Swwj record);

    int updateByPrimaryKey(Swwj record);
}