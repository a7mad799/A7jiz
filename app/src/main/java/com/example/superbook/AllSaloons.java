package com.example.superbook;

public class AllSaloons {

    private String city;
    private String saloon_name;
    private String address;

    public AllSaloons(String city, String saloon_name, String address) {
        this.city = city;
        this.saloon_name = saloon_name;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSaloon_name() {
        return saloon_name;
    }

    public void setSaloon_name(String saloon_name) {
        this.saloon_name = saloon_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
