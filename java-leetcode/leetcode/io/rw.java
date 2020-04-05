package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class rw {


    public static void main(String[] args) throws IOException {
        File dir = new File(System.getProperty("user.dir"));
        String path =dir.getAbsolutePath()+"/leetcode/io/test1.txt";
        readFile(path);
    }


    // todo rtext
    public static String readFile(String filepath) throws IOException {
        /** public StringBuffer append(String s)
         将指定的字符串追加到此字符序列。 */
        StringBuffer sb = new StringBuffer();
        File file = new File(filepath);
        if (file.exists() && file.isFile()) {
            FileInputStream fip = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
            while (reader.ready()) {
                /** append char to string buffer*/
                sb.append((char) reader.read());
            }
            /** close reader and fip stream */
            reader.close();
            fip.close();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // todo wtext
    public static void writefile(String pdir,String filename) throws IOException {
        File dir =new File(pdir);
        if(!dir.exists()){
            /** mkdir pdir */
            dir.mkdir();
        }
        File filepath=new File(pdir+filename);
        if(!filepath.exists()){
            /** touch file */
            filepath.createNewFile();
            FileOutputStream fop = new FileOutputStream(filepath);
            OutputStreamWriter writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
            writer.write("9999dftest花");
            /**close write and fop stream  */
            writer.close();
            fop.close();
        }else{
            System.out.println("file already exist");
            FileOutputStream fop = new FileOutputStream(filepath);
            OutputStreamWriter writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
            writer.append("我爱singer");
            writer.append("\n9999dftest花");
            /**close write and fop stream  */
            writer.close();
            fop.close();
        }
    }


    // todo buffer rtext
    public static String bufferReadeFile(String filepath){
        StringBuffer sb=new StringBuffer();
        try{
            FileReader reader=new FileReader(filepath);
            BufferedReader br =new BufferedReader(reader);
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        /**test output*/
        System.out.println(sb.toString());
        return sb.toString();
    }

    //todo buffer wtext
    public  static void  bufferWriteFile(String filepath){
        try{
            File filename=new File(filepath);
            /** create newfile if doesn't exist,else pass */
            if(!filename.exists()) {
                filename.createNewFile();
            }
            try{
                FileWriter writer=new FileWriter(filename);
                BufferedWriter bw= new BufferedWriter(writer);
                /** write content  to buffer*/
                bw.write(" Java is really awkward");
                /** flush content from buffer to file */
                bw.flush();
            }catch (IOException f){
                f.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //todo  read json
    /** Read jsonfile return jsonString   */
    public static  String readJsonFile(String jsonpath){
        StringBuffer sb=new StringBuffer();
        try {
            FileReader reader = new FileReader(new File(jsonpath));
            BufferedReader br=new BufferedReader(reader);
            String line =null;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

}
