package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Meeting;
import cn.edu.scu.dms.model.Swwj;

public interface ConferenceServices {
	
	public Boolean registerConference(Meeting swwj);
	public List<Meeting> getConferenceUnHolding();
	public List<Meeting> getConferenceUnHolded();
	
}
