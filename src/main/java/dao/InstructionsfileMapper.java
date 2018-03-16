package dao;

import model.Instructionsfile;

public interface InstructionsfileMapper {
    int deleteByPrimaryKey(String sequencenumber);

    int insert(Instructionsfile record);

    int insertSelective(Instructionsfile record);

    Instructionsfile selectByPrimaryKey(String sequencenumber);

    int updateByPrimaryKeySelective(Instructionsfile record);

    int updateByPrimaryKey(Instructionsfile record);
}