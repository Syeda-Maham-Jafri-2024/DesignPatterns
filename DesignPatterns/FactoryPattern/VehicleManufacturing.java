// You are designing a system for a vehicle manufacturing plant. The system needs to support the creation of different types of vehicles,
// such as cars, trucks, and motorcycles. Each vehicle type may have specific features and configurations. The system should allow for
// the addition of new vehicle types without modifying existing code.

// Requirements:

// There should be a central vehicle factory responsible for creating instances of different vehicle types.
// The vehicle factory should provide methods to create vehicles with various features, such as engine type, seating capacity, and fuel efficiency.
// Each vehicle type may have specific methods for operations, such as starting, stopping, and accelerating.
// The system must support the addition of new vehicle types in the future without requiring changes to existing code.
// Vehicles should be created based on user specifications and optional customizations.
// Challenges:

// The vehicle manufacturing system must handle variations in features and configurations for different vehicle types.
// It should be possible to create vehicles with different optional accessories and features.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary class or classes for the chosen design pattern to ensure flexible vehicle creation.
// Provide code snippets demonstrating how different parts of the application can create instances of vehicles using the factory method pattern.
import java.util.Scanner;
public class VehicleManufacturing{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter the vehicle you want: ");
        String str= sc.nextLine(); 
        Client client = new Client(str);
        vehicle Vehicle = client.getVehicle();
        System.out.println(Vehicle.getVehicleName());
        System.out.println(Vehicle.getVehicleConfig());
        System.out.println(Vehicle.getVehicleFeatures());

    }
}
interface vehicle{
    public String getVehicleName();
    public String getVehicleConfig();
    public String getVehicleFeatures();
    public void Starting();
    public void Stopping();
    public void Accelerating();
}
class cars implements vehicle{
    public String getVehicleName(){
        return "Car";
    }
    public String getVehicleConfig(){
        return " has 4 doors and 5 seater";
    }
    public String getVehicleFeatures(){
        return "Comfortable interior, spacious trunk, various engine options";
    }
    public void Starting(){
        System.out.println("the car is starting.");
    }
     public void Stopping(){
        System.out.println("the car is stopping.");
    }
     public void Accelerating(){
        System.out.println("the car is accelerating.");
    }
}
class trunks implements vehicle{
    public String getVehicleName(){
        return "Trunk";
    }
    public String getVehicleConfig(){
        return " has 4 doors and 6-8 seater";
    }
    public String getVehicleFeatures(){
        return "Flat cargo bed for easy loading and unloading of large items, heavy-duty towing capacity, rugged construction.";
    }
    public void Starting(){
        System.out.println("the trunk is starting.");
    }
     public void Stopping(){
        System.out.println("the trunk is stopping.");
    }
     public void Accelerating(){
        System.out.println("the trunk is accelerating.");
    }
}
class motorcycle implements vehicle{
    public String getVehicleName(){
        return "Motorcycle";
    }
    public String getVehicleConfig(){
        return " has No doors and 2 seater";
    }
    public String getVehicleFeatures(){
        return "High-performance engine, lightweight frame, aggressive styling, advanced suspension, quick acceleration.";
    }
    public void Starting(){
        System.out.println("the motocylce is starting.");
    }
     public void Stopping(){
        System.out.println("the motorcycle is stopping.");
    }
     public void Accelerating(){
        System.out.println("the motorcycle is accelerating.");
    }
}
class VehicleFactory{
    public static vehicle CreateVehicle(String vtype){
        if(vtype.equals("Motorcycle")){
            return new motorcycle();
        }
        else if(vtype.equals("Trunk")){
            return new trunks();
        }
        else if(vtype.equals("Car")){
            return new cars();
        }
        else{
            System.out.println("The vehicle type doesnot exists.");
        }
        return null;
    }
}
class Client{
    vehicle myvehicle;

    public Client(String vtype){
        this.myvehicle = VehicleFactory.CreateVehicle(vtype);
    }

    public vehicle getVehicle(){
        return myvehicle;
    }
}