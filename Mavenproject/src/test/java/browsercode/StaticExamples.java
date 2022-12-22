package browsercode;
import browsercode.KeywordsExample;

public class StaticExamples {
    static double pi = 3.14;
    int radius;
    {
        System.out.println("Inside static");
    }

    public StaticExamples(int radius){
        this.radius = radius;
        System.out.println("Inside constructor");
    }
    public static void main(String[] args) {
        StaticExamples s1=new StaticExamples(10);
        System.out.println("Inside main - "+StaticExamples.pi);
        KeywordsExample.m2(10);
    }

    static{
        System.out.println("Inside 2");
    }
}
