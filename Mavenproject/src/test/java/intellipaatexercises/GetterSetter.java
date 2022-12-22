package intellipaatexercises;

public class GetterSetter {
    String standard = "2C";
    int  rollNo=12;
    char section='A';

    public void setStandard(String standard){
        this.standard=standard;
    }
    public String getStandard(){
        return standard;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public static void main(String[] args) {
        GetterSetter get = new GetterSetter();
        System.out.println(get.rollNo +"  "+ get.section +" "+ get.standard);
    }
}
