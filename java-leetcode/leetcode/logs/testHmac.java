package logs;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import org.json.JSONObject;
public class testHmac {

    static String utf8="UTF-8";
    static String HMACSHA1="HmacSHA1";

    static  byte[] EncryptHmacSha1(String encryptText,String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        //deal key

        SecretKey  secretKey  = new SecretKeySpec(key.getBytes(testHmac.utf8),testHmac.HMACSHA1);
        Mac  mac = Mac.getInstance(testHmac.HMACSHA1);
        mac.init(secretKey);
        // deal text
        byte[] text = encryptText.getBytes(testHmac.utf8);
        return mac.doFinal(text);
    }

    static String  generateSignature(String applyId, String timestamp, String nonce,
                                     String appKey, String appSecret, String uri, String body ){
        String message = applyId + "\n" + timestamp + "\n" + nonce + "\n" + appKey + "\n" + uri + "\n" + body;
        String encryptText;
        try {
            encryptText = new String(message.getBytes(), testHmac.utf8); // bytes[]  to String
            byte[] hmacSha1 = testHmac.EncryptHmacSha1(encryptText,appKey);
            return Base64.getEncoder().encodeToString(hmacSha1);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public static void main(String[] args) {
            String str = "{\"age\":\"24\",\"name\":\"summer\"}";
            Map map =new HashMap();
            map.put("ke","va");
            JSONObject jsonObject =new JSONObject(map);
            //json to map
            Map mymap= jsonObject.toMap();
            System.out.println(mymap);
            //String  to map
            Map maps= new JSONObject(str).toMap();
            System.out.println(maps);
    }

}
