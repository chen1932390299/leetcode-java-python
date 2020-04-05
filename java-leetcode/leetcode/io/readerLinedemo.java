package io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readerLinedemo {


    public static void main(String[] args) throws IOException {
       List l= rline("D:\\workspace\\javahmac\\leetcode\\io\\test1.txt");
       wrline("D:\\workspace\\javahmac\\leetcode\\io\\ddd.txt",l);

    }
    static List rline(String path ) throws IOException {
        //inputstream 和inputsreamreader关系；
        //BufferedReader br = new BufferedReader(new InputStreamReader(
        //new FileInputStream(fileobject or String path)));
        //todo Reader >> inputstreamreader >> filereader
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str="";
        List list = new ArrayList();
        while ((str = br.readLine()) != null) {
               list.add(str);

        }
        // [i am good man, gjgjf, jgjggj, gjjggjg, 我]
        return list ;
    }

    static  void wrline(String path,List list) throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i <list.size() ; i++) {
            String line=(String) list.get(i);
            bf.write(line);
            bf.newLine();
            bf.flush();
        }
        bf.close();

    }

}
