package com.bootcamp.model;

import java.util.StringJoiner;

public class OrangModel {
    private int id;
    private String name;
    private String alamat;
    private String jk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public OrangModel(){
    }

    public OrangModel(int id){
        this.id = id;
    }

    public OrangModel(int id, String name){
        this.id = id;
        this.name = name;
    }


    public OrangModel(int vid, String name, String alamat, String jk) {
        this.id = vid;
        this.name = name;
        this.alamat = alamat;
        this.jk = jk;
    }

    public OrangModel(int id, String name, String alamat) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrangModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("alamat='" + alamat + "'")
                .add("jk='" + jk + "'")
                .toString();
    }
}
