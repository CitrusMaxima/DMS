package cn.edu.scu.dms.dao;

import cn.edu.scu.dms.model.Swwj;
import java.util.List;

public interface SwwjMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Swwj record);

    int insertSelective(Swwj record);

    Swwj selectByPrimaryKey(String sid);
    List<Swwj> getAllFile();

    int updateByPrimaryKeySelective(Swwj record);

    int updateByPrimaryKey(Swwj record);
}