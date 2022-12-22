package browsercode;

public class ConstructorsExample {

    static int l,b,r;
    public ConstructorsExample(int l,int b){
        this.l = l;
        this.b=b;
    }
    public ConstructorsExample(int r){
        this.r=r;
    }
    public  static double AreaRec(){
        return l*b;

    }
    public static double AreaCircle(){
        return(3.17*r);
    }
    public static void main(String[] args) {
        ConstructorsExample c1 = new ConstructorsExample(10,20);
        AreaRec();
        System.out.println(l + "b=" +b);
        ConstructorsExample c2 = new ConstructorsExample(15);
        AreaCircle();
        ConstructorsExample c3 = new ConstructorsExample(15);
        System.out.println("c2=c3" + (c2.equals(c3)));
        System.out.println("R="+r);
    }
}
