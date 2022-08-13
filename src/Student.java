public class Student extends People{
    public Student(){
        System.out.println("子类无参");
    }

    public Student(String name){
        //super(name);
        System.out.println("子类有参");

    }
}
