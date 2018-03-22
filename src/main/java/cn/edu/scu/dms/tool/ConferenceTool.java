package cn.edu.scu.dms.tool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.Mergeable;

import com.mysql.fabric.xmlrpc.base.Array;

import cn.edu.scu.dms.model.MeetingStatistical;

public class ConferenceTool {
	
	private List<String> arrayString=new ArrayList<String>();
	private List<String> total=new ArrayList<String>();
	private List<String> arrayStringAndTotal=new ArrayList<String>();
	public List<String> getArrayStringAndTotal() {
		return arrayStringAndTotal;
	}

	public void setArrayStringAndTotal(List<String> arrayStringAndTotal) {
		this.arrayStringAndTotal = arrayStringAndTotal;
	}

	public List<String> getTotal() {
		return total;
	}

	public void setTotal(List<String> total) {
		this.total = total;
	}

	private List<MeetingStatistical> meetingHold=null;
	private List<MeetingStatistical> meetingUnHold=null;
	
	public ConferenceTool(List<MeetingStatistical> meetingHold,List<MeetingStatistical> meetingUnHold){
		
		this.meetingHold=meetingHold;
		this.meetingUnHold=meetingUnHold;
		merge();
		mergeTotal();
		mergeAndTotal();
		
	}
	public void mergeAndTotal(){
		
		List<MeetingStatistical> temp1=new ArrayList<MeetingStatistical>();
		temp1.addAll(meetingHold);
	    List<MeetingStatistical> temp2=new ArrayList<MeetingStatistical>();
	    temp2.addAll(meetingUnHold);
	    
	    String yearString=null;
	    String totalString=null;
	    
	    MeetingStatistical meet1;
	    MeetingStatistical meet2;
	    
	    do{
	    	meet1=null;
		    meet2=null;
		    
	    	if(temp1!=null){
	    		
	    		if(!temp1.isEmpty())
	    		meet1=temp1.get(0);
	    		
	    	}
	    	if(temp2!=null){
	    		
	    		if(!temp2.isEmpty())
	    		meet2=temp2.get(0);
	    		
	    	}
	    	
	    	if(meet1!=null&&meet2!=null){
	    	    
	    		int year1=Integer.parseInt(meet1.getYear());
	    		int year2=Integer.parseInt(meet2.getYear());
	    		int year=0;
	    		
	    		year=year1;
	    		
	    		if(year==year2){
	    			
	    			yearString="y: '"+year+"',";
	    			totalString="a: "+(meet1.getTotal()+meet2.getTotal())+",b: "+meet1.getTotal()+",c: "+meet2.getTotal();
	    			arrayStringAndTotal.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp1.remove(0);
	    			temp2.remove(0);
	    			
	    		}else if(year<year2){
	    			
	    			yearString="y: '"+year+"',";
	    			totalString="a: "+meet1.getTotal()+",b: "+meet1.getTotal()+",c: "+0;
	    			arrayStringAndTotal.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp1.remove(0);
	    			
	    		}else{
	    			
	    			yearString="y: '"+year2+"',";
	    			totalString="a: "+meet2.getTotal()+",b: "+0+",c: "+meet2.getTotal();
	    			arrayStringAndTotal.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp2.remove(0);
	    		}
	    	 }else if(meet1!=null&&meet2==null){
	    		 	
	    		   int year1=Integer.parseInt(meet1.getYear());
	    		   yearString="y: '"+year1+"',";
	    		   totalString="a: "+meet1.getTotal()+",b: "+meet1.getTotal()+",c: "+0;
	    		   arrayStringAndTotal.add(yearString+totalString);
	    		   yearString=null;
	    		   totalString=null;
	    		   temp1.remove(0);
	    		
	    	 }else if(meet1==null&&meet2!=null){
	    		 
	    		   int year2=Integer.parseInt(meet2.getYear());
	    		   yearString="y: '"+year2+"',";
	    		   totalString="a: "+meet2.getTotal()+",b: "+0+",c: "+meet2.getTotal();
	    		   arrayStringAndTotal.add(totalString);
	    		   yearString=null;
	    		   totalString=null;
	    		   temp2.remove(0);
	    		 
	    	 }
	    	
	    }while(!((temp1==null||temp1.isEmpty())&&(temp2==null||temp2.isEmpty())));
		
	}
	public void mergeTotal(){
		
		List<MeetingStatistical> temp1=meetingHold;
	    List<MeetingStatistical> temp2=meetingUnHold;
	    
	    int total1=0;
	    int total2=0;
	    int size1=0;
	    int size2=0;
	    
	    if(temp1!=null){
	    	
	    	size1=temp1.size();
	    	for(int i=0;i<size1;i++){
	    		
	    		MeetingStatistical temp=temp1.get(i);
	    		
	    		try {
	    			total1+=temp.getTotal();
				} catch (Exception e) {
					// TODO: handle exception
				}
	    		 
	    	}
	    	
	    }
	    
	    if(temp2!=null){
	    	
	    	size2=temp2.size();
	    	for(int i=0;i<size2;i++){
	    		
	    		MeetingStatistical temp=temp2.get(i);
	    		try {
	    			total2+=temp.getTotal();
				} catch (Exception e) {
					// TODO: handle exception
				}
	    		 
	    	}
	    }
	    
	   String totalString1="label: '未召开',value: "+total1;
	   String titalString2="label: '已召开',value: "+total2;
	   total.add(totalString1);
	   total.add(titalString2);
		
	}
	
	public void merge(){
		
		List<MeetingStatistical> temp1=new ArrayList<MeetingStatistical>();
		temp1.addAll(meetingHold);
	    List<MeetingStatistical> temp2=new ArrayList<MeetingStatistical>();
	    temp2.addAll(meetingUnHold);
	    
	    String yearString=null;
	    String totalString=null;
	    
	    MeetingStatistical meet1;
	    MeetingStatistical meet2;
	    
	    do{
	    	meet1=null;
		    meet2=null;
		    
	    	if(temp1!=null){
	    		
	    		if(!temp1.isEmpty())
	    		meet1=temp1.get(0);
	    		
	    	}
	    	if(temp2!=null){
	    		
	    		if(!temp2.isEmpty())
	    		meet2=temp2.get(0);
	    		
	    	}
	    	
	    	if(meet1!=null&&meet2!=null){
	    	    
	    		int year1=Integer.parseInt(meet1.getYear());
	    		int year2=Integer.parseInt(meet2.getYear());
	    		int year=0;
	    		
	    		year=year1;
	    		
	    		if(year==year2){
	    			
	    			yearString="y: '"+year+"',";
	    			totalString="a: "+meet1.getTotal()+",b: "+meet2.getTotal();
	    			arrayString.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp1.remove(0);
	    			temp2.remove(0);
	    			
	    		}else if(year<year2){
	    			
	    			yearString="y: '"+year+"',";
	    			totalString="a: "+meet1.getTotal()+",b: "+0;
	    			arrayString.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp1.remove(0);
	    			
	    		}else{
	    			
	    			yearString="y: '"+year2+"',";
	    			totalString="a: "+0+",b: "+meet2.getTotal();
	    			arrayString.add(yearString+totalString);
	    			yearString=null;
	    			totalString=null;
	    			temp2.remove(0);
	    		}
	    	 }else if(meet1!=null&&meet2==null){
	    		 	
	    		   int year1=Integer.parseInt(meet1.getYear());
	    		   yearString="y: '"+year1+"',";
	    		   totalString="a: "+meet1.getTotal()+",b: "+0;
	    		   arrayString.add(yearString+totalString);
	    		   yearString=null;
	    		   totalString=null;
	    		   temp1.remove(0);
	    		
	    	 }else if(meet1==null&&meet2!=null){
	    		 
	    		   int year2=Integer.parseInt(meet2.getYear());
	    		   yearString="y: '"+year2+"',";
	    		   totalString="a: "+0+",b: "+meet2.getTotal();
	    		   arrayString.add(totalString);
	    		   yearString=null;
	    		   totalString=null;
	    		   temp2.remove(0);
	    		 
	    	 }
	    	
	    }while(!((temp1==null||temp1.isEmpty())&&(temp2==null||temp2.isEmpty())));
	}
	
	public List<String> getArrayString() {
		return arrayString;
	}

	public void setArrayString(List<String> arrayString) {
		this.arrayString = arrayString;
	}
	
	public  static void main(String[] args){
		
		MeetingStatistical e1=new MeetingStatistical();
		e1.setYear("2014");
		e1.setTotal(5);
		MeetingStatistical e2=new MeetingStatistical();
		e2.setYear("2016");
		e2.setTotal(5);
		MeetingStatistical e3=new MeetingStatistical();
		e3.setYear("2017");
		e3.setTotal(5);
		
		MeetingStatistical e11=new MeetingStatistical();
		e11.setYear("2015");
		e11.setTotal(5);
		MeetingStatistical e22=new MeetingStatistical();
		e22.setYear("2016");
		e22.setTotal(5);
		MeetingStatistical e33=new MeetingStatistical();
		e33.setYear("2017");
		e33.setTotal(5);
		
		List<MeetingStatistical> meetingHold=new ArrayList<MeetingStatistical>();
		List<MeetingStatistical> meetingUnHold=new ArrayList<MeetingStatistical>();
		meetingHold.add(e1);
		meetingHold.add(e2);
		meetingHold.add(e3);
		meetingUnHold.add(e11);
		meetingUnHold.add(e22);
		meetingUnHold.add(e33);
		
		ConferenceTool testConferenceTool=new ConferenceTool(meetingHold, meetingUnHold);
		
		System.out.println(testConferenceTool.getArrayString().toString());
		System.out.println(testConferenceTool.getTotal().toString());
		System.out.println(testConferenceTool.getArrayStringAndTotal().toString());
		
	}
	
}
