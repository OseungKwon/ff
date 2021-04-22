class Person{
    private Role r;
    public void setRole(Role r){
        this.r = r;
    }
    public void doIt(){
        r.doIt();
    }
}
abstract class Role{
    public abstract void doIt();
}
class Driver extends Role{
    public void doIt(){
        System.out.println("Driving");
    }
}
class Worker extends Role{
    public void doIt(){
        System.out.println("Working");
    }
}
public class chap2{
    public static void main(String[] args){
        Person p = new Person();
        p.setRole(new Driver());
        p.doIt();
        p.setRole(new Worker());
        p.doIt();
    }
}