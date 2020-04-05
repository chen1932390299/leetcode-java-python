package string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class StringBuildin {

    void strReversed(String str){
        // build in
        new StringBuilder(str).reverse();
    }

    static String ArrayJoinLang3(){
        /** split() 方法根据匹配给定的正则表达式来拆分字符串。注意： . 、 | 和 * 等转义字符，必须得加 \\。多个分隔符，可以用 | 作为连字符。*/
        String str="hello";
        String[] array = str.split(""); //[h, e, l, l, o]
        String result=ArrayUtils.toString(array,",");
        System.out.println(result);  // {h,e,l,l,o}
        return  result;
    }
    static String[] splitString(String str,String sep){
        /** split string by separator */
        return str.split(sep);
    }
    static String joinStringBuildin(String[] arr){
        /** buildin join str ,StringBuilder fast but thread not safe*/
        StringBuffer stringBuffer = new StringBuffer();
        for (String str:arr) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    static  String join(String[] arr){
        String res= StringUtils.join(arr,"");
        System.out.println(res); // hello
        return res;
    }

    static  String sliceString(String str,int start,int end){
        /** "hello"[0:3] ,字符串切割*/
        return str.substring(start,end);
    }
    static  String sliceString(String str,int start){
        /** "hello"[2],字符串切割*/
        return str.substring(start);
    }

    static  void fmt(String format,Object... args){
        /** 格式化输出  */
        String fmt = String.format("\nmy name is %s,age is %d,pi is %f",args);
        System.out.println(fmt);
    }

    /**   *
     *
     *   boolean label = a.startsWith("h");
     *   int indexOfa = a.indexOf("h");
     *   System.out.println(a.replace("l","u"));
     *   System.out.println(a.replaceFirst("l","k"));
     *  System.out.printf("strip test is :\n%s",test.trim());
     *  System.out.println(a.replaceFirst("l","k"));
     * String[] chstr =a.split(";");
     * System.out.println(Arrays.toString(a.split(";")));
     *         char[] chars = a.toCharArray();
     *         System.out.println(Arrays.toString(chars)); // [h, e, l, l, o, ;, g, o, a, l]
     *         char ch = a.charAt(0);
     *         System.out.printf("index 0  of string a'char  is: %s",a.charAt(0));
     */





    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="hello";


    }
}
