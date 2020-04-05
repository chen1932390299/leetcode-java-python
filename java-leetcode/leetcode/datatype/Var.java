package datatype;

public class Var {

    public static void main(String[] args) {

        /** data type :basic type ,引reference type variable
         * 局部变量：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
         * 成员变量：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法也就是成员方法、构造方法和特定类的语句块访问。
         * 类变量：类变量也声明在类中，方法体之外，但必须声明为static类型。
         *
         * **/
        //引用数据类型 todo 对象、数组都是引用数据类型。
        // todo 基本数据类型 八大基本数据类型  : 数据类型  变量名  初始化数据；
        // 变量是code runtime changeAble
        String name = null;
        System.out.println(name);
        // 整型
        byte byteName =1;
        long timeLong =15666666L;
        int c =8;  //4byte
        short ad = 999 ;
        // float
        float floatName=333.555766666666F;   // 4byte默认五位
        double doubleName=555.2233;  //8byte
        // 布尔型
        boolean isMan =true;
        boolean isTrue = false;
        // char字符类型
        char charName = 'A';  // 2byte(16bit)
        int dd = 0;
        // dd always true
        if (dd ==0){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
        System.out.println(Character.isAlphabetic(charName));  // boolean
    }
}
