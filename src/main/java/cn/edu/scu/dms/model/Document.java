package cn.edu.scu.dms.model;

import cn.edu.scu.dms.tool.CharacTool;
public class Document {
    private String wid;

    private String mid;

    private String wname;
    
    private CharacTool tool=new CharacTool();

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
    	wid=tool.encoding(wid);
        this.wid = wid == null ? null : wid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
    	mid=tool.encoding(mid);
        this.mid = mid == null ? null : mid.trim();
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
    	wname=tool.encoding(wname);
        this.wname = wname == null ? null : wname.trim();
    }
}