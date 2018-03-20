package cn.edu.scu.dms.model;

import java.util.Date;

import cn.edu.scu.dms.tool.CharacTool;

public class Qpwj {
    private String qpid;

    private Date qptime;

    private String title;

    private Date attribute;

    private String leaderName;

    private String zpishi;

    private String direction;

    private String note;
    private CharacTool tool=new CharacTool();

    public String getQpid() {
        return qpid;
    }

    public void setQpid(String qpid) {
    	qpid=tool.encoding(qpid);
        this.qpid = qpid == null ? null : qpid.trim();
    }

    public Date getQptime() {
        return qptime;
    }

    public void setQptime(Date qptime) {
        this.qptime = qptime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    	title=tool.encoding(title);
        this.title = title == null ? null : title.trim();
    }

    public Date getAttribute() {
        return attribute;
    }

    public void setAttribute(Date attribute) {
        this.attribute = attribute;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
    	leaderName=tool.encoding(leaderName);
        this.leaderName = leaderName == null ? null : leaderName.trim();
    }

    public String getZpishi() {
        return zpishi;
    }

    public void setZpishi(String zpishi) {
    	zpishi=tool.encoding(zpishi);
        this.zpishi = zpishi == null ? null : zpishi.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
    	direction=tool.encoding(direction);
        this.direction = direction == null ? null : direction.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
    	note=tool.encoding(note);
        this.note = note == null ? null : note.trim();
    }
}