package com.bootcamp.model.inheritance;

import com.bootcamp.model.PersonModel;

public class ManagerModel extends PersonModel {
    public String division;

    public void sayHello(String name){
        System.out.println("Hello "+ name);
    }
}
