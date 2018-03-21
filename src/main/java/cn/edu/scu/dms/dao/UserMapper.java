package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);
    List<User> getAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}