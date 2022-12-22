package browsercode;

import org.checkerframework.checker.units.qual.K;

public class KeywordsExample extends MethodOverloading{
    int a=3; //global variable
    final int f=10;

    String b="LearnMore";
    public static void main(String[] args) {

        KeywordsExample k = new KeywordsExample();
        k.m2();
        //System.out.println("Main = "+a);

    }
    public void m2(){
        int a=1;

        System.out.println(a);
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(f);
        System.out.println(super.a); //variable a is accessed from inherited class
    }

}
