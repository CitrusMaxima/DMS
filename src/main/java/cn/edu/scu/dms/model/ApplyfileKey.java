package cn.edu.scu.dms.model;

import java.util.Date;

public class ApplyfileKey {
    private String sequencenumber;

    private Date timelimit;

    public String getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(String sequencenumber) {
        this.sequencenumber = sequencenumber == null ? null : sequencenumber.trim();
    }

    public Date getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }
}