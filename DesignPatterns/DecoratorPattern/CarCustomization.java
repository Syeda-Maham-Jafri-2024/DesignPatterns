// You are developing a car customization application where users can build and customize their cars. 
//The system needs to allow users to add optional features such as leather seats, sunroof, and advanced 
//audio systems to their chosen car model.

// Requirements:
// Implement a decorator pattern to enhance the car customization functionality.
// The car model should be the base component, and optional features should be decorators.
// Users should be able to add multiple optional features to their chosen car model.
// It should be possible to introduce new optional features without modifying existing code.

// Challenges:
// Ensure that the decorator pattern supports dynamic customization of different car models.
// Design the system to handle the pricing and configuration of cars with various optional features.

// Tasks:
// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary classes for the chosen design pattern to enable flexible car customization.
// Provide code snippets demonstrating how users can customize cars with various optional features using the decorator pattern.

public class CarCustomization{
    public static void main(String[] args){
     car MyCar = new audiosystem(new leatherseat(new sunroof(new Car())));
     System.out.println("Configuration Details: " + MyCar.Configuration());
     System.out.println("Car Pricing: " + MyCar.CarPricing);
    }
}

interface car{
    public String Configuration();
    public double CarPricing();
}

class Car implements car{

    public String Configuration(){
        return "Car ";
    }

    public double CarPricing(){
        return 11000.0;
    }
}

abstract class OptionalFeatures implements car{
    protected car YourCar;

    public OptionalFeatures(car yourcar){
        YourCar = yourcar;

    }

    public String Configuration(){
       return YourCar.Configuration();
    }

    public double CarPricing(){
       return YourCar.CarPricing();
    }
}

class sunroof extends OptionalFeatures{

    public sunroof(car yourcar){
        super(yourcar);
        System.out.println("Adding sunroof to your car");
    }

    public String Configuration(){
        return YourCar.Configuration + ", sunroof ";
    }

    public double CarPricing(){
        return YourCar.CarPricing + 20.0;
    }
}

class leatherseat extends OptionalFeatures{

    public leatherseat(car yourcar){
        super(yourcar);
        System.out.println("Adding leather seat to your car");
    }

    public String Configuration(){
        return YourCar.Configuration + ", leather seat ";
    }

    public double CarPricing(){
        return YourCar.CarPricing + 50.0;
    }
}

class audiosystem extends OptionalFeatures{

    public audiosystem(car yourcar){
        super(yourcar);
        System.out.println("Adding audio system to your car");
    }

    public String Configuration(){
        return YourCar.Configuration + ", audio system ";
    }

    public double CarPricing(){
        return YourCar.CarPricing + 40.0;
    }
}