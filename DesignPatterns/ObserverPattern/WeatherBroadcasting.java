// You are developing a weather station application that collects data from various sensors and broadcasts it to multiple display 
//devices and analytics modules. The goal is to ensure that new display devices can be easily added to the system without modifying
// existing code, and each device can choose to receive specific types of weather data.

// Requirements:

// There should be a central weather data manager responsible for collecting and broadcasting weather updates.
// Display devices and analytics modules should be able to subscribe to specific types of weather data dynamically.
// The system should support future expansion by allowing the addition of new types of weather data without modifying existing components.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements in this scenario.
// Implement the necessary classes for the chosen design pattern to achieve a flexible and extensible weather data broadcasting system.

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WeatherBroadcasting{
    public static void main(String[] args){
        Radio radio = new Radio();
        Monitor monitor = new Monitor();
        Laptop laptop = new Laptop();

        heatsensor heat = new heatsensor();
        heat.register(radio);
        heat.unregister(laptop);
        heat.notifyObservers();        
        System.out.println();

        windsensor wind = new windsensor();
        wind.register(laptop);
        wind.register(radio);
        wind.register(monitor);
        wind.notifyObservers();
        wind.unregister(monitor);
        System.out.println();

        lightsensor light = new lightsensor();
        light.register(radio);
        light.notifyObservers();

    }
}
interface subject{
    public void register(Observer a);
    public void unregister(Observer b);
    public void notifyObservers();
}
class heatsensor implements subject{
    private List<Observer> obs = new ArrayList<Observer>();
    
    public void register(Observer a){
        obs.add(a);
        System.out.println(a.name() + "has subscribed to heat sensor.");

    }
    public void unregister(Observer b){
       int index = obs.indexOf(b);
       if(index !=-1){
        obs.remove(index);
        System.out.println(b.name() + "has unsubscribed to heat sensor.");
       }
       else{
        System.out.println("Error: " + b.name()+ "is not registered to heat sensor!!");
        
       }
    }
    public void notifyObservers(){
     String message = "A change has been detected by the heat sensor";
     for(Observer observe: obs){
        observe.update(message);
     }
    }
}
class lightsensor implements subject{
    private List<Observer> obs = new ArrayList<Observer>();
    
    public void register(Observer a){
        obs.add(a);
        System.out.println(a.name() + "has subscribed to light sensor.");

    }
    public void unregister(Observer b){
       int index = obs.indexOf(b);
       if(index !=-1){
        obs.remove(index);
        System.out.println(b.name() + "has unsubscribed to light sensor.");
       }
       else{
        System.out.println("Error: " + b.name()+ "is not registered to light sensor!!");
       }
    }
    public void notifyObservers(){
     String message = "A change has been detected by the light sensor";
     for(Observer observe: obs){
        observe.update(message);
     }
    }
}
class windsensor implements subject{
    private List<Observer> obs = new ArrayList<Observer>();
    
    public void register(Observer a){
        obs.add(a);
        System.out.println(a.name() + "has subscribed to wind sensor.");

    }
    public void unregister(Observer b){
       int index = obs.indexOf(b);
       if(index !=-1){
        obs.remove(index);
        System.out.println(b.name() + "has unsubscribed to wind sensor.");
       }
       else{
        System.out.println("Error: " + b.name()+ "is not registered to wind sensor!!");
       }
    }
    public void notifyObservers(){
     String message = "A change has been detected by the wind sensor";
     for(Observer observe: obs){
        observe.update(message);
     }
    }
}

interface Observer{
    public String name();
    public String update(String msg);
}
class Radio implements Observer{
    public String name(){
      return "Radio";  
    }
    public String update(String msg){
        return name() + " has been notified of the update: " + msg;
    }
}
class Laptop implements Observer{
    public String name(){
      return "Laptop";  
    }
    public String update(String msg){
        return name() + " has been notified of the update: " + msg;
    }
}
class Monitor implements Observer{
    public String name(){
      return "Monitor";  
    }
    public String update(String msg){
        return name() + " has been notified of the update: " + msg;
    }
}