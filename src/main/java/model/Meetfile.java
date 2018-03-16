package model;

import java.util.Date;

public class Meetfile {
    private String meetnumber;

    private Date meettime;

    private String caller;

    private String meetnature;

    private String participant;

    private String meetplace;

    public String getMeetnumber() {
        return meetnumber;
    }

    public void setMeetnumber(String meetnumber) {
        this.meetnumber = meetnumber == null ? null : meetnumber.trim();
    }

    public Date getMeettime() {
        return meettime;
    }

    public void setMeettime(Date meettime) {
        this.meettime = meettime;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
    }

    public String getMeetnature() {
        return meetnature;
    }

    public void setMeetnature(String meetnature) {
        this.meetnature = meetnature == null ? null : meetnature.trim();
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
    }

    public String getMeetplace() {
        return meetplace;
    }

    public void setMeetplace(String meetplace) {
        this.meetplace = meetplace == null ? null : meetplace.trim();
    }
}