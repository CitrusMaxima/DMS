package cn.edu.scu.dms.services;

import cn.edu.scu.dms.model.User;

import com.mysql.jdbc.UpdatableResultSet;

public interface AccountServices {
	public  User getUser(String id);
	public  int insertUser(User user);
	
}
