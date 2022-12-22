package intellipaatexercises;

public class Intellipaat_Record {
    String name;
    int roll_number;

    public Intellipaat_Record(String name, int roll_number){
        this.name=name;
        this.roll_number=roll_number;
    }
    public static void main(String[] args) {
        Intellipaat_Record intelli = new Intellipaat_Record("Ravi",123);
        System.out.println(intelli.name + " " + intelli.roll_number);

        Intellipaat_Record intelli2 = new Intellipaat_Record("Varshu",3435);
        System.out.println(intelli2.name + " " + intelli2.roll_number);
        System.err.println();
    }

}
