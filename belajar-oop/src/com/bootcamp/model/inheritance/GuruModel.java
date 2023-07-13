package com.bootcamp.model.inheritance;

import com.bootcamp.model.OrangModel;

import java.util.StringJoiner;

public class GuruModel extends OrangModel {
    private String nip;
    private String gelar;
    private String mapel;

    public GuruModel(int vid, String name, String alamat, String jk, String nip, String gelar, String mapel) {
        super(vid, name, alamat, jk);
        this.nip = nip;
        this.gelar = gelar;
        this.mapel = mapel;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuruModel.class.getSimpleName() + "[", "]")
                .add("id=" + this.getId())
                .add("name='" + this.getName() + "'")
                .add("alamat='" + this.getAlamat() + "'")
                .add("jk='" + this.getJk() + "'")
                .add("nip='" + nip + "'")
                .add("gelar='" + gelar + "'")
                .add("mapel='" + mapel + "'")
                .toString();
    }
}
