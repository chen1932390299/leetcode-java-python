package com.SuperDoc;

public class Son extends Father  {


    /** 1.子类方法中有一个默认赠送super（）构造方法
     * 2。子类可以重载父类构造方法，因为构造方法是无法被重写的，static 修饰方法也是无法被重写的
     * 3.must first statement of son constructor
     * //overide argslist 相同发生在继承关系 ,overload args list 不同
     * 重写注意子类返回范围小于等于父类返回范围 Object  String
     * 重写注意子类变量权限必须大于等于父类变量权限
     * 父类的成员方法只能被它的子类重写。重写发生在成员方法
     *
     * 声明为 final 的方法不能被重写。
     * */

    int age;
    String name ;

//    public Son(){
//        System.out.println("son no param constructor");
//    }
    public Son(String name ,int age ){
        super(name);
        this.age =age ;
        this.name=name;
        System.out.println("son has param constructor");
        System.out.println(this.age+"  " + this.name);
    }

    void t(){

        System.out.println(super.name);
    }
    void callF(){
        super.fmtFather();
    }


}
