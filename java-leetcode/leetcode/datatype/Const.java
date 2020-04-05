package datatype;

public class Const {

    // const 程序运行过程中不会发生改变的变量
    double pi=3.14;
    float a =3.555f;
    char b = 'A';

    public static void main(String[] args) {
        // todo string to 转字符数组 char[]
        char[] list ="adfff".toCharArray();
        System.out.println(list.getClass().getName()+"<<<<<< list type ");
        // char join to StringBuilder
        StringBuilder str = new StringBuilder();
        System.out.println("str type is "+str.getClass().getName());
        for (int i = 0; i<list.length ; i++) {
            str.append(list[i]);
        }
        System.out.println(str);
        int c =97; // a
        // int convert char
        char my_char = (char) c ;
        System.out.println(my_char);


    }

}
