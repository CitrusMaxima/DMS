package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Applyfile;
import cn.edu.scu.dms.model.ApplyfileKey;

public interface ApplyfileMapper {
    int deleteByPrimaryKey(ApplyfileKey key);

    int insert(Applyfile record);

    int insertSelective(Applyfile record);

    Applyfile selectByPrimaryKey(ApplyfileKey key);

    int updateByPrimaryKeySelective(Applyfile record);

    int updateByPrimaryKey(Applyfile record);
}