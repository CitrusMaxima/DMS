package cn.edu.scu.dms.model;

import java.util.Date;

public class Instructionsfile {
    private String sequencenumber;

    private Date receivetime;

    private String filetitle;

    private String level1instructions;

    private String level2instructions;

    private Date timelimit;

    private String handingsituation;

    private String telephone;

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

    public String getFiletitle() {
        return filetitle;
    }

    public void setFiletitle(String filetitle) {
        this.filetitle = filetitle == null ? null : filetitle.trim();
    }

    public String getLevel1instructions() {
        return level1instructions;
    }

    public void setLevel1instructions(String level1instructions) {
        this.level1instructions = level1instructions == null ? null : level1instructions.trim();
    }

    public String getLevel2instructions() {
        return level2instructions;
    }

    public void setLevel2instructions(String level2instructions) {
        this.level2instructions = level2instructions == null ? null : level2instructions.trim();
    }

    public Date getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    public String getHandingsituation() {
        return handingsituation;
    }

    public void setHandingsituation(String handingsituation) {
        this.handingsituation = handingsituation == null ? null : handingsituation.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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