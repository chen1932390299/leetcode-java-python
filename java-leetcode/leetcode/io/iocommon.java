package io;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class iocommon {

    public static void main(String[] args)throws IOException {
        wrfiletest();

    }

    static void readOneline() throws IOException {

        String path = iocommon.class.getResource("test1.txt").getFile();
        // 等价上一行
        String getpath = iocommon.class.getResource("test1.txt").getPath();
        System.out.println(path+"\n"+getpath);
        File file =new File(path);
        LineIterator  it = FileUtils.lineIterator(file);
        byte[] b =FileUtils.readFileToByteArray(file);
        String text= FileUtils.readFileToString(file,"utf-8");
        List list = FileUtils.readLines(file,"utf-8");
        System.out.println(list.size());

        // iter
        for(LineIterator iter = it; iter.hasNext(); ) {
            String  line = iter.next();
            System.out.println(line);
        }
    }


    static  void wrfiletest() throws IOException {
        //String path =iocommon.class.getResource("").getPath(); //.getPath();todo getpdir
        String path = System.getProperty("user.dir");
        File file2 =new File(path,"leetcode/io");
        System.out.println(file2.getPath());
        File  file =new File(file2,"test3.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.getPath());
        FileUtils.write(file,"woaini","utf-8",true); // 末尾追加 woainiwoaini
        FileUtils.write(file,"woainisf","utf-8",true);
    }



}
