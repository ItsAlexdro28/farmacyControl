package com.farmacy.typeid.domain.entity;

public class TypeId {
    private int id;
    private String document;

    public TypeId(int id, String document) {
        this.id = id;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
