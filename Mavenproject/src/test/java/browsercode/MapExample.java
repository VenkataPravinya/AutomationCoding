package browsercode;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(123,"Aravinth");
        hm.put(234,"Ravi");
        hm.put(345,"Varshu");
        System.out.println(hm);

        for(Map.Entry output: hm.entrySet()){


            System.out.println(output.getKey());
            System.out.println(output.getValue());
        }
    }

}
