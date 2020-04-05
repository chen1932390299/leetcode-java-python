package io;

import java.io.File;
import java.io.IOException;

public class createFile {

    public static void main(String[] args)throws IOException {


        File file= new File("./abc/def/test.txt");
        File pdir = file.getParentFile();
        if(!pdir.exists()){
            pdir.mkdirs();
        }
        file.createNewFile();
    }
}
