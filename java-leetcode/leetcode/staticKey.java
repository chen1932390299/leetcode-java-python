public class staticKey {

    // todo 一旦使用了static 关键字这个变量不再属于单个对像而是属于整个类
    static String name ;  // 静态变量，也叫类变量
    private int  ages;  // 成员变量

    //todo  static 修饰的方法，静态方法，属于类，不属于对象,可以new 创建的对象来调用(不推荐)；类可以call
    //todo 本类的静态可以直接被静态方法访问，静态方法不可以访问后创建的成员方法,但是非静态方法可以调用静态方法，后人知道前人
    //先人不知后人，后人知前人，static 在内存中先有静态内容，后有非静态内容
    static  void demo(String args){
        System.out.println(args);
        //static call non-static err
//        he();
        //System.out.println(ages); // todo ERROR 静态方法不可以访问成员变量，我不知后世有你
     }


     void he(){
        // todo non-static call static method ,成员方法可以访问静态变量（也叫类变量）和成员变量
        demo("ddd");
        System.out.println(name);
        System.out.println(ages);
     }

    public static void main(String[] args) {
        staticKey st= new staticKey();
        st.he();
    }

}
