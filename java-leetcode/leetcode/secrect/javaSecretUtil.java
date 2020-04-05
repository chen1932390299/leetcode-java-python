package secrect;

import org.apache.commons.codec.digest.DigestUtils;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


/**
 * dependency : org.apache.commons.codec==1.1.4 and org.apache.commons.lang3==3.9
 */
public class javaSecretUtil {
    static final String Hmac_algorithm = "HmacSHA1";
    static String utf8="utf-8";
    public static void main(String[] args) {
        //md5test("hello","str");
//        hexSha256Msg("hello,你好");
//        sha256hex("hello,你好");
        EncryptHmacSha1("hello","key", javaSecretUtil.Hmac_algorithm);   // s0zqxFFv8joUPmHXnQ+npPvl8mY=
    }


    static String  md5test(String text,String returnType)  {
        /** md5() return byte[],md5hex()   return String hex */
        String result=null;
        if (returnType.equals("str")){
             result = DigestUtils.md5Hex(text);
             System.out.println(result);  // 5d41402abc4b2a76b9719d911017c592
        }else if(returnType.equals("byteArray")){
            byte[] res = DigestUtils.md5(text);
            System.out.println(byteToHex(res));// 5d41402abc4b2a76b9719d911017c592
        }
       //new String((byte[]) res)
        return result;
}
    public static String byteToHex(byte[] bytes){
        /**byte[] 转hex 16 进制 */
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }



    public static String md5(String Text) {
        /** java.util 自带类*/
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(Text.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        System.out.println(md5code);  //5d41402abc4b2a76b9719d911017c592
        return md5code;
    }

    static  String jdkBase64(String text) {
        /** jdk java.util 自带类 */
        String res= null;
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            //Base64.Decoder decoder = Base64.getDecoder();
            //System.out.println(new String(decoder.decode(encodedStringText), "UTF-8"));
            byte[] data = text.getBytes("UTF-8");
            res = encoder.encodeToString(data); // byte[] is medium change type
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        System.out.println(res);
        return res ;
    }

    static String hexSha256Msg(String text) {
        /**  hex sha256 64 bit length ,java.util + byteToHex() */
        String str=null;
        byte[] data = text.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data);
            byte[] bytes = md.digest();
            str = byteToHex(bytes);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        System.out.println(str);
        return str ;
    }

    static String sha256hex(String text){
        /** codec sha256 */
        String str =null;
        try{
            str = DigestUtils.sha256Hex(text);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(str);
        return str ;
    }

    static  String EncryptHmacSha1(String encryptText,String key,String ALGORITHM){
        String res=null;
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(javaSecretUtil.utf8),ALGORITHM);
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(secretKey);
            // deal text
            byte[] text = encryptText.getBytes(javaSecretUtil.utf8);
            byte[] bytes = mac.doFinal(text);
            res = Base64.getEncoder().encodeToString(bytes);
            System.out.println(res);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res ;
    }

}
