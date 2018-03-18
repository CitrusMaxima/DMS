package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String cid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}