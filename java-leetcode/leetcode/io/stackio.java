package io;
import java.io.*;
public class stackio {
    /**阅读字符流–类
     读取字符流的所有类都扩展java.io.Reader。重要的类有：

     InputStreamReader-此类从基础流读取字节，并使用Charset将其转换为字符。它充当字节流和字符流之间的桥梁
     PipedReader-此类连接到PipedWriter并从中读取字符。
     BufferedReader-从字符输入流读取字符并缓冲数据。缓冲可以有效地读取行或字符数组。它包裹在另一个读取器中，该读取器读取单个字符的数据，例如FileReader或InputStreamReader
     FileReader-这是用于从文件读取字符的便捷类。它扩展了InputStreamReader。它使用默认的编码方案和字节缓冲区。要指定其他编码方案或字节缓冲区，请在FileInputStream上创建InputSteamReader的实现。
     编写字符流–类
     所有编写字符流的类都扩展了java.io.Writer。重要的类别是：

     OutputStreamWriter-此类使用指定的字符集将字符编码为字节，充当字符流和字节流之间的桥梁
     FileWriter-此类扩展了OutputStreamWriter，并且是用于写入文件的便捷方法。它使用默认的编码和缓冲区大小。若要指定其他缓冲区大小或编码方案，请在FileOutputStream上创建一个OutputStreamWriter
     PipedWriter-可以连接到PipedReader。它将字符写入由PipedReader读取的流中。
     PrintWriter-此类格式化对象并将其写入字符流。它对某些方法具有自动冲洗功能。它从不抛出IOException。此类非常有用，例如，如果已启用自动刷新，则将方法println（String s）写入字符串s，写入newLine，然后刷新流 ，以将其写入文件。
     BufferedWriter在将字符缓冲后将其写入字符流。提供了newLine（）方法，该方法将平台行分隔符写入该流。*/

    static void  charWithoutBuffer()throws IOException,FileNotFoundException
    {
        /**字节流 without buffer    */
        FileReader reader = null;
        FileWriter writer = null;
        reader = new FileReader("in.txt");
        writer = new FileWriter("out.txt");
        int a = 0;
        while ((a = reader.read()) != -1) {
            writer.write(a);
        }
        reader.close();
        writer.close();

    }


    static  void charBuffer() throws IOException {
        /**字节流 with buffer    */
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("in.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                // write a new line
                bufferedWriter.newLine();
                // flush
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close without throwing exception
            bufferedReader.close();
            bufferedWriter.close();
        }

    }



}

class BytesRw{
    /**读取字节–类
     java.io中读取数据的基本类是java.io.InputStream。读取字节的所有类均派生自此类。该类由以下类扩展。后面将有详细的示例，但让我们以10000英尺的高度查看这些类。我们将仅关注最重要的课程。

     FileInputStream-此流从文件读取原始字节。此类中的read方法返回从文件读取的数据字节。
     ObjectInputStream-此类用于读取使用ObjectOutputStream编写的对象。它反序列化原始数据类型和对象
     PipedInputStream-可以使用此类完成Unix'pipe'之类的实现。它可以连接到pipedoutputsteam并从中读取数据。
     BufferedInputStream-这可能是最常用的类。它缓冲来自上述任何输入流的数据。此类中的方法提高了读取效率，因为它们尝试读取一次操作即可从文件系统读取的最大字节数。
     ByteArrayInputStream-此类包含一个缓冲区（数组）或字节，用于存储将从流中读取的下几个字节。
     写字节–类
     所有写入字节的类都扩展java.io.OutputStream。重要的类有：

     FileOutputStream-此类中的方法将数据字节写入文件。请注意，这将写入原始字节，而不是字符。
     ObjectOutputStream –将原始Java类型和对象写入输出流。数据可以写入文件或套接字。使用此方法写入的数据可以使用ObjectInputStream读回。
     PipedOutputStream-管道输出流连接到PipedInputStream以读取字节。数据可以由一个线程写入，而由另一个线程读取。
     BufferedOutputStream-缓冲来自输入流的数据并写入缓冲的数据。这是一种有效的数据写入方法，因为操作系统可能在单个操作中写入字节数组，而对每个字节调用写入操作可能效率很低。
     PrintStream-它包装InputStream并添加了功能以打印各种数据值表示形式。它从不抛出IOException，并且有一个自动刷新的选项
     ByteArrayOutputStream-此类在字节数组中写入字节。*/

     static  void byteReader(){

     }


    static  void byteWriter(){

    }



}


