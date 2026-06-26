class Student implements Cloneable{
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major)
    {
        this.name=name;
        this.age=age;
        this.major=major;
    }
    public String getname()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getMajor()
    {
        return major;
    }
    public void setMajor(String major)
    {
        this.major=major;
    }

    @Override
    public String toString()
    {
        return "Student [name=" + name +", age="+ age +", major=" + major + "]" ;
    }

    @Override
    public Student clone() throws CloneNotSupportedException{
        return(Student) super.clone();
    }
}

public class StudentManagement {
    public static void main(String[] args)
    {
        try{
            Student student1= new Student("Utkarsh", 22, "Master of Computer Application");
            Student student2= student1.clone();

            System.out.println("Original Student"+ student1);
            System.out.println("Cloned Student"+ student2);

            student2.setName("Purnima");
            student2.setAge(22);
            student2.setMajor("Bachelor's of Fine Arts");

            System.out.println("After Modifying the cloned object:");
            System.out.println("Original Student"+ student1);
            System.out.println("Cloned Student"+ student2);
        }
        catch(CloneNotSupportedException cnse){
            System.out.println("You can't clone this object");
        }
    }
}
