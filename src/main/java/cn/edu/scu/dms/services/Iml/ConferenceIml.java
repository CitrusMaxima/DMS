package cn.edu.scu.dms.services.Iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.MeetingMapper;
import cn.edu.scu.dms.model.Meeting;
import cn.edu.scu.dms.model.MeetingStatistical;
import cn.edu.scu.dms.services.ConferenceServices;

@Service
public class ConferenceIml implements ConferenceServices {

	@Autowired
	MeetingMapper mapper;
	
	@Transactional
	public Boolean registerConference(Meeting swwj) {
		// TODO Auto-generated method stub
		mapper.insert(swwj);
		return true;
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
		return temp;
	}

    @Transactional
	public void updateMeeting(Meeting meeting) {
		mapper.updateByPrimaryKey(meeting);
	}

	@Transactional
	public Boolean deleteMeetingById(String mid) {
		// TODO Auto-generated method stub
	   mapper.deleteByPrimaryKey(mid);
	   return true;
	}

	@Override
	public List<MeetingStatistical> getMeetingHold() {
		// TODO Auto-generated method stub
		List<MeetingStatistical> temp=null;
		temp=mapper.getMeetingStatisticalsHold();
		return temp;
	}

	@Override
	public List<MeetingStatistical> getMeetingUnHold() {
		// TODO Auto-generated method stub
		List<MeetingStatistical> tempList=null;
		tempList=mapper.getMeetingStatisticalsUnHold();
		return tempList;
	}

}
