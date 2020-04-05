package Random;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class lang3Stringutil {

    public static void main(String[] args) {


    randReplaceFalse(10);
    ownDefineString(10);
    strReplaceFalse(100000,7);
    }

    static String  ownDefineString(int length){
        /**  自定义随机样本*/
        String a=RandomStringUtils.random(length, "1234567890");
        System.out.println(a);
        return a;
    }

    static String  randString(int len){
        /** Stringbuffer is thread safely,but stringbuilder is not safe */
        String samples="abcdef123456";
        StringBuffer stringBuffer = new StringBuffer();  //java.lang.StringBuffer
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            stringBuffer.append(samples.charAt(random.nextInt(samples.length())));
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString(); // String type
     }

     static String  randRangeString(int start,int end){
        /** randNumber 将被赋值为一个 [MIN,MAX] 范围内的的长度字符串*/

        Random rand = new Random(); //可以指定种子
        int numeric=  rand.nextInt(end - start + 1) + start;
        String result= randString(numeric);
        System.out.println(result);
        return  result;
     }
     static  int randInteger(int min,int max){
         /** generate numeric [min,max) */
         Random rand = new Random();
         return rand.nextInt(max-min)+min;

     }

     static  String randStringUtil(int min, int max){
        /**alpha+digits 3st */
        System.out.println(RandomStringUtils.randomAlphanumeric(min,max)); //afB9uO49Uzt
        return RandomStringUtils.randomAlphanumeric(min,max);
     }
    static  String randIntegerUtil(int min, int max){
        /** integer digits  3st */
        System.out.println(RandomStringUtils.randomNumeric(min,max));
        return RandomStringUtils.randomNumeric(min,max);
    }

    static String randSizeString(int size){
        /** generate  size length of digits string 3st : 73802 */
        System.out.println(RandomStringUtils.randomNumeric(size));
        return RandomStringUtils.randomNumeric(size);
    }

    //todo 随机不重复数字
    static List randReplaceFalse(int numbers){
        ArrayList list = new ArrayList();
        int n = numbers;
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        System.out.println(list);
        return list;
    }



    static HashSet strReplaceFalse(int n,int strlength){
        /**  hashset not  repeated set */
        HashSet set =new HashSet();

        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            String num = RandomStringUtils.randomAlphabetic(strlength);
            set.add(num);
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            strReplaceFalse( n - setSize,strlength);// 递归
        }
        System.out.println(set.size());
        return set;
    }

}
