package com.bootcamp.main;

import com.bootcamp.model.OrangModel;

public class MainOrang {
    public static void main(String[] args) {
        OrangModel org1 = new OrangModel();
        System.out.println(org1);

        OrangModel org2 = new OrangModel(1,"ROni","Ciparakan","Pria");
        System.out.println(org2);

        OrangModel org3 = new OrangModel(1);
        System.out.println(org3);

        OrangModel org4 = new OrangModel(2,"Topa");
        System.out.println(org4);

        OrangModel org5 = new OrangModel(3,"Adel","Jakarta");
        System.out.println(org5);
    }
}
