package browsercode;

public class Circle {

    int r;
    public Circle(int r) {
        this.r=r;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5);
        System.out.println("c1=c2" + (c1==c2));
        System.out.println("c1=c2" + (c1.equals(c2)));
    }
}
