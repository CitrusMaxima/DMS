package cn.edu.scu.dms.model;

import java.util.Date;

import cn.edu.scu.dms.tool.CharacTool;

public class Meeting {
    private String mid;

    private Date mtime;

    private String host;

    private String characters;

    private String place;

    private String names;

    private Boolean ishold;
    private CharacTool tool=new CharacTool();

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
    	mid=tool.encoding(mid);
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
    	host=tool.encoding(host);
        this.host = host == null ? null : host.trim();
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
    	characters=tool.encoding(characters);
        this.characters = characters == null ? null : characters.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
    	place=tool.encoding(place);
        this.place = place == null ? null : place.trim();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
    	names=tool.encoding(names);
        this.names = names == null ? null : names.trim();
    }

    public Boolean getIshold() {
        return ishold;
    }

    public void setIshold(Boolean ishold) {
        this.ishold = ishold;
    }
}