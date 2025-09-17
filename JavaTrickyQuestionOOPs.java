class Parent {
    // Parent method returning Object
    public Object show() {
        System.out.println("Parent show() method");
        return "Parent";
    }
}

class Child extends Parent {
    // Overriding method with covariant return type (String is a subclass of Object)
    @Override
    public Integer show() {
        System.out.println("Child show() method");
        return 1;
    }
}

public class JavaTrickyQuestionOOPs {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        Child p2 = new Child(); // Polymorphism
        Child c1 = new Child();

        System.out.println(p1.show()); // Calls Parent's method
        System.out.println(p2.show()); // Calls Child's method (runtime overriding)
        System.out.println(c1.show()); // Calls Child's method
    }
}
