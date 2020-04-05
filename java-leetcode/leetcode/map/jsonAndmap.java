package map;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class jsonAndmap {

    /**  denpendended by fastjson.JSON */
    public static Map jsonStrToMap(String jsonStr){
//        Map<String,Object> map = JSON.parseObject(jsonStr,Map.class);
        Map map = (Map)JSON.parse(jsonStr);
        System.out.println(map);
        return map;
    }

    public static void main(String[] args) {
        // todo org json map互转
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
