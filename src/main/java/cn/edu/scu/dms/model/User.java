package cn.edu.scu.dms.model;

import cn.edu.scu.dms.tool.CharacTool;

public class User {
    private String uid;

    private String password;

    private String name;

    private Boolean ismanager;

    private String phonenumber;

    private String email;
    private CharacTool tool=new CharacTool();

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
    	uid=tool.encoding(uid);
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	password=tool.encoding(password);
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    	name=tool.encoding(name);
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsmanager() {
        return ismanager;
    }

    public void setIsmanager(Boolean ismanager) {
        this.ismanager = ismanager;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
    	phonenumber=tool.encoding(phonenumber);
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}