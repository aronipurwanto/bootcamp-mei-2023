package com.bootcamp.model;

import java.util.StringJoiner;

public class PersonModel {
    public int id;
    public String name;
    public String address;
    public String gender;

    public void showData(){
        System.out.println("id= "+ id);
        System.out.println("name= "+ name);
        System.out.println("address= "+ address);
        System.out.println("gender= "+ gender);
    }

    public void showData2(){
        String data = new StringJoiner(", ", OrangModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("alamat='" + address + "'")
                .add("jk='" + gender + "'")
                .toString();
        System.out.println(data);
    }
}
