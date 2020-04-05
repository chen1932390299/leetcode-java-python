package ClassDefine;

import ClassDefine.Person;

public class PersonDemo {
    public static void main(String[] args) {
        // 数组在代码一旦启动，长度无法改变
        Person[] array =new Person[3];
        Person one = new Person("DILI",23);
        Person two= new Person("maerzhaha",23);
        Person three= new Person("gulinazha",23);
        array[0]=one;
        array[1]=two;
        array[2]=three;
        System.out.println(array[0].getName());
    }
}
