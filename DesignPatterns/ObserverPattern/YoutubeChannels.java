import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class YoutubeChannels{
    public static void main(String[] args){
        User1 myuser1 = new User1();
        User2 myuser2 = new User2();
        User3 myuser3 = new User3();

        YoutubeChannel1 channel1 = new YoutubeChannel1();
        YoutubeChannel2 channel2 = new YoutubeChannel2();

        channel1.register(myuser1);
        channel1.register(myuser3);
        channel1.unregister(myuser3);
        channel1.notifyObservers("a new vedio has been uploaded");
        
        channel2.register(myuser2);
        channel2.unregister(myuser1);

        channel1.notifyObservers("a new vedio has been uploaded");

    }
}


interface subject{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObservers(String message);
}
class YoutubeChannel1 implements subject{
    private List<Observer> obs = new ArrayList<Observer>();

    public void register(Observer a){
        obs.add(a);
        System.out.println(a.name() + " has registered to Youtube Channel 1");
    }

    public void unregister(Observer b){
        int index = obs.indexOf(b);
        if (index != -1) {
        obs.remove(index);
        System.out.println(b.name() + " has unregistered from Youtube Channel 1");}
        else{
            throw new NoSuchElementException( b.name() + " is not registered to Youtube Channel 1!");
    }
    }

    public void notifyObservers(String message){
        for(Observer observer: obs){
            observer.update(message);
        }
    }
}
class YoutubeChannel2 implements subject{
    private List<Observer> obs = new ArrayList<Observer>();

    public void register(Observer a){
        obs.add(a);
        System.out.println(a.name() + " has registered to Youtube Channel 2");
    }

    public void unregister(Observer b){
        int index = obs.indexOf(b);
        if (index != -1) {
        obs.remove(index);
        System.out.println(b.name() + " has unregistered from Youtube Channel 2");}
        else{
            throw new NoSuchElementException( b.name() + " is not registered to Youtube Channel 2!");
        }
    }

    public void notifyObservers(String message){
        for(Observer observer: obs){
            observer.update(message);
        }
    }
}

interface Observer{
    public String name();
    public void update(String message);
}
class User1 implements Observer{
    public String name(){
        return "User 1";
    }
    public void update(String message){
        System.out.println(name() + " has been notified about the recent update: ");
    }
}
class User2 implements Observer{
    public String name(){
        return "User 2";
    }
    public void update(String message){
        System.out.println(name() + " has been notified about the recent update: " + message);
    }
}
class User3 implements Observer{
    public String name(){
        return "User 3";
    }
    public void update(String message){
        System.out.println(name() + " has been notified about the recent update" + message);
    }
}