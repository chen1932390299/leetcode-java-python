package Array;

import java.util.Arrays;

public class ArrayDemo {
    // 数组capacity 一旦定义不可修改
    public static void main(String[] args) {
      revereArray();
    }

    static void docArray() {
        /** Array 创建方式2以及格式，确定数组内容用静态，不确定数组长度用动态 */
        //1. dataType[] arrayRefVar = new dataType[arraySize]; //todo 指定数组长度动态初始化
        //2. dataType[] arrayRef =  {value0, value1, ..., valuek};// todo 执行数组内容，静态初始化,没有指定长度，但会推算长度
        int[] arrayRef = new int[5];  // array[0]=1
        Arrays.fill(arrayRef, 3, 4, 5); // todo 填充数组

        System.out.println(Arrays.toString(arrayRef)); // [0, 0, 0, 5, 0]
    }

    static void binSearch(double[] doubleArray) {
        /** 二分查找数组  */
        //double[] do = new double[] { 99.5, 100, 98, 97.5, 100, 95, 85.5, 100 };
        Arrays.sort(doubleArray); // todo array 排序
        int index1 = Arrays.binarySearch(doubleArray, 100);
        System.out.println("查找到 索引 第一次出现100 的位置是：" + index1);
    }

    static void iterArray(Object[] array) {
        /** iter Array */
        for (Object o : array
        ) {
            System.out.println(o);
        }
        // double array
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        for (double element : myList) {
            System.out.println(element);
        }
    }

    static  void omitFormat(){
        /** 省略初始化 array,且不支持步骤拆分两部分，第一步ref数据组type,数组变量名称 */
        int[] array = {1,3,5}; // todo 不要new int[]
    }
    //直接打印数组array ,打印数组的内存条的内存地址hash值
    //todo 访问数组元素方式
    static void  accessArray(){
        // 十六进制：0123456789abcdef，char \u0000, float 0.0 int 0 , boolean false, reftype null ;
        String[] a =new String[5]; // 没有填0 填充
        a[0]="aa";
        a[1]="44";
        a[3]="ff";
        String num = a[2];
        System.out.println(num);
        System.out.println(Arrays.toString(a)); // [aa, 44, null, ff, null]
    }
    // todo 所有引用型变量都可以赋值为为null ,都必须new 初始化话才可以调用否则空指针异常
    static int maxArrayValue() {
        /**find  max value of Array */
        int[] arr = new int[]{66, 4, 555, 33,555,68};
        int max = arr[0]; //to 擂台
        for (int i = 0; i < arr.length; i++) {
            int fi = arr[i];
            if (fi > max) {
                max = fi;
            }
        }
        System.out.println(max);
        return max;
    }

    //reverse
    static  int[] revereArray(){
        // reverse array ,不能用新数组，对称位置的数据交换，什么时候交换，什么时候停止交换：
        // 1.min_index== max_index 2.min_index<max_index,水杯思想交换
        int[] arr =new int[]{66, 4,555, 33,555,68};
        for (int min = 0,max=arr.length-1; min <max ; min++,max--) {
            int temp = arr[min];
            arr[min] =arr[max];
            arr[max] =temp;
        }
//        System.out.println(Arrays.toString(arr)); // todo p89 chapter
        return arr;
    }


}
