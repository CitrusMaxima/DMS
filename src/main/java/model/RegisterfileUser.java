package model;

import java.util.Date;

public class RegisterfileUser {
    private String sequencenumber;

    private Date receivetime;

    private String sourceunit;

    private String filetitle;

    private Date handingtime;

    private String level2instructions;

    private String direction;

    private String filepath;

    public String getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(String sequencenumber) {
        this.sequencenumber = sequencenumber == null ? null : sequencenumber.trim();
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public String getSourceunit() {
        return sourceunit;
    }

    public void setSourceunit(String sourceunit) {
        this.sourceunit = sourceunit == null ? null : sourceunit.trim();
    }

    public String getFiletitle() {
        return filetitle;
    }

    public void setFiletitle(String filetitle) {
        this.filetitle = filetitle == null ? null : filetitle.trim();
    }

    public Date getHandingtime() {
        return handingtime;
    }

    public void setHandingtime(Date handingtime) {
        this.handingtime = handingtime;
    }

    public String getLevel2instructions() {
        return level2instructions;
    }

    public void setLevel2instructions(String level2instructions) {
        this.level2instructions = level2instructions == null ? null : level2instructions.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }
}