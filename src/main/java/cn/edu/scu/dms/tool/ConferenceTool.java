package cn.edu.scu.dms.tool;

import java.util.List;

import cn.edu.scu.dms.model.MeetingStatistical;

public class ConferenceTool {
	
	String arrayString=null;
	List<MeetingStatistical> meetingHold=null;
	List<MeetingStatistical> meeetingUnHold=null;
	
	public ConferenceTool(List<MeetingStatistical> meetingHold,List<MeetingStatistical> meeetingUnHold){
		
		this.meetingHold=meetingHold;
		this.meetingHold=meeetingUnHold;
		
	}
	
	public String getArrayString() {
		return arrayString;
	}

	public void setArrayString(String arrayString) {
		this.arrayString = arrayString;
	}
	
	
	
}
