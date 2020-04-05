package io;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class iodemo {


    public static void main(String[] args)throws IOException {
        String src = "D:\\workspace\\javahmac\\leetcode\\io\\test1.txt";
        String dest= "D:\\workspace\\javahmac\\leetcode\\io\\test2.txt";
//        readThenWrite(src,dest);
          bufferWrite(src,dest);

    }
    static  String readMethod(@NotNull String path) throws IOException {
         /** Return string */
         InputStream in = new FileInputStream(path);
         byte[] bytes = new byte[1024];  //todo onetime read bytes length !!!
         int num=0;
         // todo -1 表示文件指针到文件末尾，其他则返回num代表文件指针当前的位置，off表示byte 数组存放的偏移量
         //   read()  * @返回读入缓冲区的字节总数，或者
        //      -1表示如果由于末尾没有更多数据，已到达流。
         StringBuilder builder= new StringBuilder(); // String str="";也可以
         while ((num=in.read(bytes,0,bytes.length))!=-1){
              // str += new String(bytes, 0, num);也可以
              builder.append(new String(bytes, 0, num)); // 一次转换多少字节为字符串,保留换行符等等

        }
         System.out.println(builder);  // todo 带换行符号
         return builder.toString();
    }

    @Deprecated
    static void writeMethod(String path,@Nullable String mode,String text) throws IOException {
        /** write bytes[] to file   */
        byte[] content = text.getBytes();
        if(mode.equals("w")){
            OutputStream out =new FileOutputStream(path,false); // w
            out.write(content);
        }
        if(mode.equals("a")){
            OutputStream out =new FileOutputStream(path,true); // true 追加写 a+
            out.write(content);
        }

    }
    /** onetime r onetime w */
    static void readThenWrite(String src,String dest) throws IOException {
        InputStream in = new FileInputStream(src); //todo append可以追加，如果dest不存在自动创建；
        OutputStream out = new FileOutputStream(dest);

        // todo 一次性取多少字节
        byte[] bytes = new byte[1024];
        //todo 文件指针-1表示最后一行
        int num ;
        while ((num = in.read(bytes,0,bytes.length)) != -1) {
            //todo 一次转换每次读取的字节为string
            String str = new String(bytes,0,num); //这里可以实现字节到字符串的转换，比较实用
            System.out.println(str);
            //todo 每次写入多少字节
            out.write(bytes, 0, num);
        }
        //CLOSE STREAM
        in.close();
        out.close();
    }

    static String bufferRead(String src) throws FileNotFoundException,IOException {

        //读取文件(缓存字节流)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));

        //todo 一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        String str="";
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            str += new String(bytes,0,n);//charset utf-8 defaults
            //System.out.println(str);
        }
        in.close();
        return str.toString();
    }

    static  void  bufferWrite(String src,String dest) throws IOException {
        //读取文件(缓存字节流)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //写入相应的文件
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //todo 循环取出数据,长度为bytes.length
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n, StandardCharsets.UTF_8);
            System.out.println(str);
            //写入相关文件
            out.write(bytes, 0, n);
        }
        //清除缓存
        out.flush();
        //关闭流
        in.close();
        out.close();

    }


}
