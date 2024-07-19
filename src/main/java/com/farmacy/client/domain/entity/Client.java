package com.farmacy.client.domain.entity;

public class Client {
    private int id;
    private int typeId;
    private String names;
    private String lastNames;
    private int age;
    private String birthDate;
    private String registDate;
    private int district;
    
    public Client(int id, int typeId, String names, String lastNames, int age, String birthDate, String registDate, int district) {
        this.id = id;
        this.typeId = typeId;
        this.names = names;
        this.lastNames = lastNames;
        this.age = age;
        this.birthDate = birthDate;
        this.registDate = registDate;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }


}