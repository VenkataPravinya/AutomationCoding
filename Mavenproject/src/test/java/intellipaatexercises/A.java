package intellipaatexercises;

import java.io.IOException;
import java.util.Scanner;

public class A {

    protected int value=10;
    protected void Rectangle(){

    }

    public static void main(String[] args) throws IOException {
        String s="Hello how are you";
        String[] subStr = s.split(" ");
        for(String s2:subStr){
            System.out.println("Str=" + s2);
        }

    }
}
