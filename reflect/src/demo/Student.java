package demo;

public class Student {
    private String name;
    private int age;

    private Student(){}
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    private void eat(){
        System.out.println("正在吃··");
    }

    public void sleep(){
        System.out.println("ZZZZZ·····");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name:" + name +
                ", age:" + age +
                "}";
    }
}
