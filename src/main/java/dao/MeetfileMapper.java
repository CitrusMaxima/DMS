package dao;

import model.Meetfile;

public interface MeetfileMapper {
    int deleteByPrimaryKey(String meetnumber);

    int insert(Meetfile record);

    int insertSelective(Meetfile record);

    Meetfile selectByPrimaryKey(String meetnumber);

    int updateByPrimaryKeySelective(Meetfile record);

    int updateByPrimaryKey(Meetfile record);
}