package dao;

import model.Applyfile;
import model.ApplyfileKey;

public interface ApplyfileMapper {
    int deleteByPrimaryKey(ApplyfileKey key);

    int insert(Applyfile record);

    int insertSelective(Applyfile record);

    Applyfile selectByPrimaryKey(ApplyfileKey key);

    int updateByPrimaryKeySelective(Applyfile record);

    int updateByPrimaryKey(Applyfile record);
}