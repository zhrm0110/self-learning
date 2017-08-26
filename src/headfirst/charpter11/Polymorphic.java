package headfirst.charpter11;

class Animal {
    public void sound() {
        System.out.println("a, a, a,...");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("wang, wang, wang,...");
    }

    public void saveDoor() {
        System.out.println("I'm a dog and I can save the door");
    }
}

public class Polymorphic {

    public static void main(String[] args) {
        // 验证多态特性。
        Animal dog = new Dog();
        dog.sound();// 调用父子都有的方法，实际执行子类复写的逻辑（如果子类复写过的话）
        ((Dog) dog).saveDoor();// 调用子类扩展的方法则必须先强制转换为自类类型，否则编译报错。
    }

}
