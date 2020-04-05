package map;

import java.util.HashMap;
import java.util.Map;

public class map {


    // put get remove(key) remove(k,v) clear() ,keySet :keys ,values,size, containsKey(Object key) ,containsValue(Object value)
    // putAll(), 新杯子，a, medium ,b
    //如果此映射包含指定键的映射，则返回

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("one", "一");
        map1.put("two", "二");
        map1.put("three", "三");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("three", "三");
        // 合并
        Map<String, String> combineResultMap = new HashMap<String, String>();
        combineResultMap.putAll(map1);
        combineResultMap.putAll(map2);
    }
}
