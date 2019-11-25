package com.example.superbook;

public class user {

    private String full_name;
    private String phone;
    private int year;
    private String password;

    public user(String full_name, String phone, int year, String password) {
        this.full_name = full_name;
        this.phone = phone;
        this.year = year;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
