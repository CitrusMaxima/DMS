package cn.edu.scu.dms.services;

import cn.edu.scu.dms.model.User;
import java.util.List;

public interface AccountServices {
	public  User getUser(String id);
	public List<User> getAllUser();
	public  int insertUser(User user);
	public void update(User user);
	public Boolean deleteUser(String id);
}
