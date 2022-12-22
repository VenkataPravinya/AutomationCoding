package browsercode;


import static java.awt.SystemColor.info;

public class ClassDemo {
    public static void main(String[] args) {
        String test = "hello";
        Class testClass = info.getClass();
        System.out.println(" class name= " + testClass.getName());
        Class testClass2 = null;
        try {
            testClass2 = Class.forName("EqualsEx");
            System.out.println(" " +testClass2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
