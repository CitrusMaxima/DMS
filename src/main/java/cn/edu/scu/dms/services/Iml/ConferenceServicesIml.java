package cn.edu.scu.dms.services.Iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.MeetingMapper;
import cn.edu.scu.dms.model.Meeting;
import cn.edu.scu.dms.services.ConferenceServices;

@Service
public class ConferenceServicesIml implements ConferenceServices {

	@Autowired
	MeetingMapper mapper;
	
	@Transactional
	public Boolean registerConference(Meeting swwj) {
		// TODO Auto-generated method stub
		mapper.insert(swwj);
		return null;
	}

	@Transactional
	public Meeting getMeetingById(String id) {
		// TODO Auto-generated method stub
		Meeting temp=null;
		temp=mapper.selectByPrimaryKey(id);
		return temp;
	}

    @Transactional
	public List<Meeting> getAllMeetings() {
		// TODO Auto-generated method stub
    	List<Meeting> temp=null;
    	temp=mapper.getAll();
		return null;
	}

}
