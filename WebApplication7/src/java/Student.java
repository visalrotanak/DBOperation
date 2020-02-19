
public class Student {
    
    private int id;
    private String firstName;
    
    public Student(){}
    public Student(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
    }
    public void setId(int id){this.id = id;}
    public void setName(String firstName){this.firstName = firstName;}
    public int getId(){return this.id;}
    public String getName() {return this.firstName;}
    
}
