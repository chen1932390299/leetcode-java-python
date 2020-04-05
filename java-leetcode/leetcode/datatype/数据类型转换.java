package datatype;

public class 数据类型转换 {

    public static void main(String[] args) {
        //TODO s数据类型转换：1.自动转换，2.强制转换人工

        //1.自动类型转换，数据范围从小到大：byte,short,char—> int —> long—> float —> double
        System.out.println(Byte.MIN_VALUE+","+Byte.MAX_VALUE); //-128,127
        System.out.println(Integer.MIN_VALUE+","+Integer.MAX_VALUE);  // -2147483648,2147483647 21亿
        System.out.println(Long.MIN_VALUE+","+Long.MAX_VALUE);  // -9223372036854775808,9223372036854775807
        System.out.println(Float.MIN_VALUE+","+Float.MAX_VALUE); // 1.4E-45,3.4028235E38
        System.out.println(Double.MIN_VALUE+","+Double.MAX_VALUE);  // 4.9E-324,1.7976931348623157E308
        //强制转换 格式： 范围小类型 范围小变量名 = （范围小类型） 范围大的数据
        //强制转换会有精度丢失风险，会装不下就内存溢出，大数据倒进小水桶，小水桶倒入大水桶
        int integer = 100;
        float b=(float) integer;
        System.out.println(b);
        int convert_lose = (int) 3.999;
        System.out.println(convert_lose); // 3 精度丢失
        long a1 =6000000000L;
        int a2 = (int) a1; //todo 右边的数据范围不可以超过左边的数据范围
        System.out.println(a2); //1705032704
        byte i =40;
        byte j = 90;
        //byte k = i+j; // todo Error:(24, 19) java: 不兼容的类型: 从int转换到byte可能会有损失,正确：byte k= (byte) i+j

        //todo  byte/short/char >>>int 会计算时先提升为int

      /**  基本数据类型不属于面向对象范畴，不属于对象*/

    }
}
