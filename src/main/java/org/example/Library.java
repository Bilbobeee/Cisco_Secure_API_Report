package org.example;

import java.util.ArrayList;

public class Library {

    ArrayList<String> list = new ArrayList<>();

    {
        list.add("S_G_");
        list.add("S_R_");
        list.add("Ch_G_");
        list.add("Ch_R_");
        list.add("D_G_");
        list.add("D_R_");
        list.add("K_G_MK_");
        list.add("Mykolaiv_G_");
        list.add("M_G_");
        list.add("M_R_");
    }

    public ArrayList<String> filling(){
        return list;
    }

}
