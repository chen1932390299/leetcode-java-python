package operator;

import java.util.Comparator;

public class TernaryOPerator {
    public static void main(String[] args) {
        /**  三元运算符*/
        int a=5;
        int b=3;
        int maxNum= a<b ? a : b;
        System.out.println(maxNum);
        // lambda 表达式
        Comparator<Integer> cmp = Integer::compare;
        int compare = cmp.compare(1000, 244);  // true return 1 ,false return -1
        System.out.println(compare);


    }
}
