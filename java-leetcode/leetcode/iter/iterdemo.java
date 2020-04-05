package iter;
import java.util.*;

public class iterdemo {
    public static void main(String[] args) {

        // 用来迭代容器的,next() ,hasNext(),set 不可以for循环
        Set set = new HashSet();
        Set set2 =new TreeSet();
        set.add(1);
        set.add(2);
        Iterator it =set.iterator();
        while(it.hasNext()){
//            Integer integer = (Integer)it.next();
            int integerss = (int)it.next();
            System.out.println(integerss);
        }

        HashMap<String,Object> map =new HashMap<>();
        map.put("k1","2333");
        map.put("k2",555);
        //map.map iter 1
        Set keySet = map.keySet();
        Iterator it2 = keySet.iterator();
        while (it2.hasNext()){
            String key =(String) it2.next();
            String v = map.get(key).toString();  // java.lang.Integer cannot be cast to java.lang.String强转
            System.out.println(key+" : "+v);

        }
        //map.map 2 iter,todo by keySet iter
        Set entryset = map.entrySet(); // key|value   k2|v2
        Iterator it3 = entryset.iterator();
        while (it3.hasNext()){
            Map.Entry entry = (Map.Entry) it3.next();
            String key =entry.getKey().toString();
            String value =entry.getValue().toString();
            System.out.println(key+": "+value);
        }

        //map3 bigMap,,for (Map.Entry<String,String> entry :map.map.entrySet())
        for (Map.Entry<String,Object> entry :map.entrySet()) {
            String key=entry.getKey();
            String value=entry.getValue().toString();
            System.out.println(value+":"+key);
        }



    }


}
