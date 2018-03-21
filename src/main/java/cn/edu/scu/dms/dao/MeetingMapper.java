package cn.edu.scu.dms.dao;

import java.util.List;

import cn.edu.scu.dms.model.Meeting;

public interface MeetingMapper {

	int deleteByPrimaryKey(String mid);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(String mid);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    
    List<Meeting> getAll();
}