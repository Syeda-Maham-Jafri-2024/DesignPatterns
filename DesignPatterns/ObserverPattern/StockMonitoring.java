import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StockMonitoring{
    public static void main(String[] args){
        DisplayComponents display = new DisplayComponents();
        AlertSystem alert = new AlertSystem();

        stock1 s1 = new stock1();
        s1.register(display);
        s1.register(alert);
        s1.notifyObservers();
        System.out.println();
        stock2 s2 = new stock2();
        s2.register(display);
        s2.unregister(alert);
        s2.notifyObservers();

    }
}
interface subject{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObservers();
}
class stock1 implements subject{
    private List<Observer> obs = new ArrayList<Observer>();

    public void register(Observer a){
      obs.add(a);
      System.out.println(a.name() + " has subscribed to Stock 1.");
    }
    public void unregister(Observer b){
     int index = obs.indexOf(b);
     if(index != -1){
        obs.remove(index);
        System.out.println(b.name() + "has unsubscribed from the Stock 1.");
     }
    else{
        System.out.println("Error: " + b.name() + " hasnt subsribed to Stock 1.");
     }
    }
    public void notifyObservers(){
        String message = "There has been a change in the stock prices.";
        for(Observer observe : obs){
            System.out.println(observe.update(message));
        }
    }
}
class stock2 implements subject{
    private List<Observer> obs = new ArrayList<Observer>();

    public void register(Observer a){
      obs.add(a);
      System.out.println(a.name() + " has subscribed to Stock 2.");
    }
    public void unregister(Observer b){
     int index = obs.indexOf(b);
     if(index != -1){
        obs.remove(index);
        System.out.println(b.name() + " has unsubscribed from the Stock 2.");
     }
     else{
        System.out.println("Error: " + b.name() + " hasnt subsribed to Stock 2.");
     }
    }
    public void notifyObservers(){
        String message = " There has been a change in the stock prices.";
        for(Observer observe : obs){
            System.out.println(observe.update(message));
        }
    }
}
interface Observer{
    public String name();
    public String update(String message);
}
class DisplayComponents implements Observer{
    public String name(){
        return "Display Component";
    }
    public String update(String message){
        return name() + "has been notified about the update: " + message;
    }
}
class AlertSystem implements Observer{
    public String name(){
        return "Alert System ";
    }
    public String update(String message){
        return name() + "has been notified about the update: " + message;
    }
}