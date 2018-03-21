package cn.edu.scu.dms.services;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.edu.scu.dms.model.Meeting;
import cn.edu.scu.dms.model.MeetingStatistical;
import cn.edu.scu.dms.model.Swwj;

public interface ConferenceServices {
	
	public Boolean registerConference(Meeting meeting);
	public Meeting getMeetingById(String id);
	public List<Meeting> getAllMeetings();
	public void updateMeeting(Meeting meeting);
	public Boolean deleteMeetingById(String mid);
	public List<MeetingStatistical> getMeetingHold();
	public List<MeetingStatistical> getMeetingUnHold();
}
