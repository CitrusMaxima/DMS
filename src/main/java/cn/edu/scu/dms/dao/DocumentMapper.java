package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(String wid);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}