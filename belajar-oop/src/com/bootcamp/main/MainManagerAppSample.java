package com.bootcamp.main;

import com.bootcamp.model.inheritance.ManagerModel;

public class MainManagerAppSample {
    public static void main(String[] args) {
        ManagerModel man = new ManagerModel();
        man.id = 1;
        man.name = "Roni";
        man.address = "Ciamis";

        man.sayHello("Roni");
        System.out.println("show data call...");
        man.showData2();
    }
}
