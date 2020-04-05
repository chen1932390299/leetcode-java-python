package com.SuperDoc;

public class Father {


    String  name="father name is joy";
    int age =40;

//    public Father(){
//        System.out.println("this is no param constructor ");
//    }
    public Father(String name){
        this.name =name ;
        System.out.println("this is father has param constructor "+"father name is"+this.name);
    }

    void fmtFather(){
        System.out.println("this is father method ");
    }
}
