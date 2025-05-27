package utcn;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    public void move(){
        System.out.println("Moving...");
    }
    public static void movingVehicles(List<Vehicle> vehicles){
       for(Vehicle vehicle : vehicles){
           vehicle.move();
       }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car());
        vehicles.add(new Bicycle());
        vehicles.add(new Car());
        vehicles.add(new Bicycle());
        movingVehicles(vehicles);
    }
}

class Car extends Vehicle{
    public void move(){
        System.out.println("The car is moving...");
    }
}

class Bicycle extends Vehicle{
    public void move(){
        System.out.println("The bicycle is moving...");
    }
}
