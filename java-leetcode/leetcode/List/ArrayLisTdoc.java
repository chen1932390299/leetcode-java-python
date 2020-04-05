package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayLisTdoc {
    //ArrayList 集合长度可变创建过后
    public static void main(String[] args) {
        List k =new ArrayList(); // TODO This is List create
        ArrayList<Integer> ints=new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(4);
        int v =ints.get(0); // todo get by index of ArrayList
        System.out.println(ints.contains(4)); // true
        getSmallList(ints);

    }
    static  void infoArrayList(){
        //泛型E必须都是引用类型,不可以是基本类型byte,int long short
        // ArrayList<E> list =new ArrayList<>();右侧尖括号里类型可以不写，默认会与左边保持一致，左边还是要写的，E表示泛型，list里都是String 类型
        //保存的是内容，不是地址
        // 向ArrayList放基本类型,需要借助包装类Integer,Float,Short,Double,Long,Character,Boolean
        //jdk1.5+支持自动装箱，拆箱：基本类型==》包装类型
        ArrayList<String> list =new ArrayList<>();
        System.out.println(list);
        list.add("hello");

    }

    static ArrayList<Integer>  getSmallList(ArrayList<Integer> bigArrayList){

        //
        ArrayList<Integer> smallList =new ArrayList<>();
        for (int i = 0; i < bigArrayList.size(); i++) {
            int num =bigArrayList.get(i);
            if(num %2==0){
                smallList.add(num);
            }
        }
        System.out.println(smallList);
        return smallList;

    }





}
