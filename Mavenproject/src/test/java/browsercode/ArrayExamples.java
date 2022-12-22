package browsercode;

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayExamples {
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<Integer>();
        ls.add(10);
        ls.add(20);
        ls.add(80);
        ls.add(15);
        ls.remove(2);

        for(Integer output:ls){
            System.out.println(output);
        }

        List<String> listString = new LinkedList<String>();
        listString.add("Hi");
        listString.add("Hello");
        listString.add("world");
        for(String outString:listString){
            System.out.println(outString);
        }
        listString.add("denmark");
        for(String outString:listString){
            System.out.println(outString);
        }

        String s = "12,345";
        String s1 = s.substring(0,2);
        String s2 = s.substring(3,6);
        String s3 = s1.concat(s2);
        //int a= Integer.parseInt(s3);
        System.out.println("S1 =" + s1 + "\nS2=" + s2);
        System.out.println(s3);
    }
}
