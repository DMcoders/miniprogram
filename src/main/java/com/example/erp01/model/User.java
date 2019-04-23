package com.example.erp01.model;

public class User {

    private Integer userID;

    private String userName;

    private String passWord;

    private String role;

    private String phoneNumber;

    private String userCardID;

    public User(String userName, String passWord, String role, String phoneNumber, String userCardID) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.userCardID = userCardID;
    }

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserCardID() {
        return userCardID;
    }

    public void setUserCardID(String userCardID) {
        this.userCardID = userCardID;
    }
}
