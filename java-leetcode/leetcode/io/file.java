package io;
import java.io.File;
import java.io.IOException;

public class file {


    public static void main(String[] args) throws IOException {

        File file =new File("test.txt");
        File file2 =new File("/usr/local");
        //create file
        file.createNewFile();
        // getfileObject
        File f = file.getParentFile();
        // getfiledirName
        String pdir= file.getParent();
        // mkdir dir empty
        file2.mkdir();
        file2.mkdirs();
        file.renameTo(new File("test2.txt"));
        file.delete();
        //  file exits
        file.exists();
        file.getPath();
        file.isDirectory();
        file.isAbsolute();
        file.isFile();
        file.length(); // file's size


    }
}
