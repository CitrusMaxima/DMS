package cn.edu.scu.dms.dao;

import java.util.List;
import cn.edu.scu.dms.model.Qpwj;

public interface QpwjMapper {
    int deleteByPrimaryKey(String qpid);

	int insertSelective(Qpwj record);

    int insert(Qpwj record);


    Qpwj selectByPrimaryKey(String qpid);

    int updateByPrimaryKeySelective(Qpwj record);

    int updateByPrimaryKey(Qpwj record);
    
    List<Qpwj> getAllFile();
}