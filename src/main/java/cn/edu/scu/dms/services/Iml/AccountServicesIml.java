package cn.edu.scu.dms.services.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.UserMapper;
import cn.edu.scu.dms.model.User;
import cn.edu.scu.dms.services.AccountServices;

@Service
public class AccountServicesIml implements AccountServices {
   
	@Autowired
	UserMapper userdao;
	
	
	public User getUser(String id) {
		// TODO Auto-generated method stub
		User selectUser=userdao.selectByPrimaryKey(id);
		return selectUser;
	}

	@Transactional
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		User tempUser=getUser(user.getUid());
		if(tempUser==null){
			userdao.insert(user);
			return 1;
		}
		else{
			return 0;
		}
	}

}
