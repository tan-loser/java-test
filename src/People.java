public class People {
    private String name;

    public People(){
        System.out.println("父类无参");
    }

    public People(String name){
        this.name = name;
        System.out.println("调用父类有参");
    }
}
