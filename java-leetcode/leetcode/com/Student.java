package com;

public class Student {

    private String name ;
    private int age ;
    public Student(){
        System.out.println("this is inti ");
    }

    public Student(String name,int age ){
        this.name=name ;
        this.age =age ;
        System.out.println("this is init with param");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // todo 成员方方法，不能使用static修饰
    public  void eat(){
        System.out.println("eating ");
    }
    public  String hha(){
        return " ";
    }
}
