package utcn;

public interface Flyable {

    void fly();
    default void land(){
        System.out.println("Landing...");
    }

    static void checkWeather(){
        System.out.println("Checking weather...");
    }
}

class Bird implements Flyable{
    public void fly(){
        System.out.println("Bird is flying...");
    }
}

class Airplane implements Flyable{
    public void fly(){
        System.out.println("Airplane is taking off to fly...");
    }
}

class TestClass{
    public static void main(String[] args) {
        Flyable.checkWeather();

        Airplane airplane = new Airplane();
        airplane.fly();
        airplane.land();

        Bird bird = new Bird();
        bird.fly();
        bird.land();
    }
}
