package string;

public class MemAddrChange {
    public static void main(String[] args) {


        // const 常量区， 堆区 new String() 从const区Copy 一份
        String  str1 = "hello";
        String  str2 = "hello";
        String  str3 =new String("hello");
        System.out.println(str1==str3); //false
        System.out.println(str1==str2); // == compare point addr,引用地址
        System.out.println(str1.equals(str3));  // compare content of mem
    }
}


class  Dog{
    int a =11;
}