package com.bootcamp.model.inheritance;

import com.bootcamp.model.OrangModel;

import java.util.StringJoiner;

public class SiswaModel extends OrangModel {
    private String kelas;
    public SiswaModel(int vid, String name, String alamat, String jk, String kelas) {
        super(vid, name, alamat, jk);
        this.kelas = kelas;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SiswaModel.class.getSimpleName() + "[", "]")
                .add("id=" + this.getId())
                .add("name='" + this.getName() + "'")
                .add("alamat='" + this.getAlamat() + "'")
                .add("jk='" + this.getJk() + "'")
                .add("kelas='" + kelas + "'")
                .toString();
    }

    /*
    public SiswaModel() {
    }

    public SiswaModel(int id) {
        super(id);
    }

    public SiswaModel(int id, String name, String kelas) {
        super(id, name);
        this.kelas = kelas;
    }

    public SiswaModel(int id, String name, String alamat, String kelas) {
        super(id, name, alamat);
        this.kelas = kelas;
    }
*/
}
