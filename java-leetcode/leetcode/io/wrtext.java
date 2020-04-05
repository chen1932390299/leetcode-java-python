package io;

import java.io.*;

public class wrtext {

    public static void main(String[] args)throws IOException {

        wrtext w = new wrtext();
        w.repFileContent();
    }

    void readFileDemo()throws IOException{
        // 读取文件
        File file =new  File("D:\\workspace\\javahmac\\leetcode\\io\\test1.txt");
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024]; // bytes.length
        int len=0;
        while((len=in.read(bytes))!=-1){
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }

    void repFileContent()throws IOException{
        /** 字节流 + bufferReader/bufferWriter*/
        File file =new  File("D:\\workspace\\javahmac\\leetcode\\io\\test1.txt");
        File file2 =new  File("D:\\workspace\\javahmac\\leetcode\\io\\test2.txt");
        FileReader  fr = new FileReader(file);
        FileWriter fw = new FileWriter(file2);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw =new BufferedWriter(fw);

        String line= "";
        //todo readline 一次读一行
        while((line=br.readLine())!=null){
            line= line.replaceAll("good","bad");
            bw.write(line);
            bw.newLine(); // 换行
        }
        // final
        br.close();
        bw.flush();
        bw.close();

    }

    void demo()throws IOException{
        // wr txt
        File file =new  File("test1.txt");
        //创建流
        FileInputStream in = new FileInputStream(file);
        int symbol = in.read();  //TODO WARNNING read()一次只读一个字节,源码解释》》Reads a byte of data from this input stream. This method blocks
        System.out.println(symbol);
    }

}
