package browsercode;

public class EqualsEx implements Cloneable{
    int a=10;
    String val="hello";

    public static void main(String[] args) {
        EqualsEx e1= new EqualsEx();
        System.out.println(e1.a + e1.val);
        EqualsEx e2 = new EqualsEx();
        System.out.println("E2="+e2.a+e2.val);
        System.out.println("Equals=  "+e2.equals(e1));
    }
    public boolean equals(EqualsEx ex){
        if((this.a == ex.a) && (this.val==ex.val)){
            return true;
        }
        else return false;
    }
}
