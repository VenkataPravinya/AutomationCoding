package browsercode;

public class MethodOverloading {
    int a=25;
    public static void main(String[] args) {

        m2(4,5);
    }

    public static void m2(int a){
        System.out.println(a);
    }
    public static void m2(int a, int b){
        System.out.println(a + b);
    }
    public static void m2(String a, int b){

    }
    public static void m2(String a, String b){

    }
}
