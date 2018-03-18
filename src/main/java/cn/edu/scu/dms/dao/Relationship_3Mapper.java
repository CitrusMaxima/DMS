package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Relationship_3Key;

public interface Relationship_3Mapper {
    int deleteByPrimaryKey(Relationship_3Key key);

    int insert(Relationship_3Key record);

    int insertSelective(Relationship_3Key record);
}