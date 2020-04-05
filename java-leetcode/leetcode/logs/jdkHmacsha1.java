package logs;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class jdkHmacsha1 {
    static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    static String utf8="utf-8";
    static  String EncryptHmacSha1(String encryptText,String key,String HMAC_SHA1_ALGORITHM){
        String res=null;
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(testHmac.utf8), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(secretKey);
            // deal text
            byte[] text = encryptText.getBytes(jdkHmacsha1.utf8);
            byte[] bytes = mac.doFinal(text);
            res = Base64.getEncoder().encodeToString(bytes);
            System.out.println(res);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res ;
    }

    public static void main(String[] args) {
        EncryptHmacSha1("hello","key",jdkHmacsha1.HMAC_SHA1_ALGORITHM);
    }


}
