package cn.edu.scu.dms.model;

import java.util.Date;

public class Pswj {
    private String pid;

    private Date rectime;

    private String numbers;

    private String title;

    private String spishi;

    private String wpishi;

    private Date deadline;

    private String isdone;

    private String phone;

    private String direction;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Date getRectime() {
        return rectime;
    }

    public void setRectime(Date rectime) {
        this.rectime = rectime;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers == null ? null : numbers.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSpishi() {
        return spishi;
    }

    public void setSpishi(String spishi) {
        this.spishi = spishi == null ? null : spishi.trim();
    }

    public String getWpishi() {
        return wpishi;
    }

    public void setWpishi(String wpishi) {
        this.wpishi = wpishi == null ? null : wpishi.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getIsdone() {
        return isdone;
    }

    public void setIsdone(String isdone) {
        this.isdone = isdone == null ? null : isdone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }
}