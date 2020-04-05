package logs;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class codecHmacSha1 {
    static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    static String hmacSha1(String text,String key,String HMAC_SHA1_ALGORITHM){
        String  result = null;
        try {
            SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signinKey);
            byte[] rawHmac = mac.doFinal(text.getBytes());
            byte[] bytes = Base64.encodeBase64(rawHmac);
            result =new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return  result;
    }

    public static void main(String[] args) {
        hmacSha1("hello","key",codecHmacSha1.HMAC_SHA1_ALGORITHM);
    }
}
