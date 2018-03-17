package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Meetfile;

public interface MeetfileMapper {
    int deleteByPrimaryKey(String meetnumber);

    int insert(Meetfile record);

    int insertSelective(Meetfile record);

    Meetfile selectByPrimaryKey(String meetnumber);

    int updateByPrimaryKeySelective(Meetfile record);

    int updateByPrimaryKey(Meetfile record);
}