package cn.edu.scu.dms.model;

import java.util.Date;

public class Applyfile extends ApplyfileKey {
    private Date time;

    private String sourceperson;

    private String sourcetitle;

    private String instructions;

    private String instructior;

    private String direction;

    private String comment;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSourceperson() {
        return sourceperson;
    }

    public void setSourceperson(String sourceperson) {
        this.sourceperson = sourceperson == null ? null : sourceperson.trim();
    }

    public String getSourcetitle() {
        return sourcetitle;
    }

    public void setSourcetitle(String sourcetitle) {
        this.sourcetitle = sourcetitle == null ? null : sourcetitle.trim();
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }

    public String getInstructior() {
        return instructior;
    }

    public void setInstructior(String instructior) {
        this.instructior = instructior == null ? null : instructior.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}