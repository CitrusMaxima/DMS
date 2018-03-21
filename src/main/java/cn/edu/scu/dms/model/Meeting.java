package cn.edu.scu.dms.model;

import java.util.Date;

public class Meeting {
    private String mid;

	private Date mtime;

	private String host;

	private String characters;

	private String place;

	private String names;

	private Boolean ishold;

	private String document;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
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
		this.host = host == null ? null : host.trim();
	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters == null ? null : characters.trim();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? null : place.trim();
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names == null ? null : names.trim();
	}

	public Boolean getIshold() {
		return ishold;
	}

	public void setIshold(Boolean ishold) {
		this.ishold = ishold;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document == null ? null : document.trim();
	}
}