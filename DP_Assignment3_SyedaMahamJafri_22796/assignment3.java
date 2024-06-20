// Syeda Maham Jafri, 22796
// Observer Pattern
import java.util.ArrayList;
import java.util.List;

public class assignment3{
    public static void main(String[] args){

        ClockTimer clocktimer = new ClockTimer(14, 60, 60);

        Observer analogClock = new AnalogClock();
        Observer digitalClock = new DigitalClock();

        clocktimer.attach(analogClock);
        clocktimer.attach(digitalClock);

        clocktimer.tick();
        
        clocktimer.detach(analogClock);
        clocktimer.tick();
    }
}

abstract class Subject{
     List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer attach){
      observers.add(attach);
    }
    public void detach(Observer detach){
        observers.remove(detach);

    }
    public void Notify(){
        for(Observer observer: observers){
            observer.update(this);
        }

    }


}
class ClockTimer extends Subject{
    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;

    public ClockTimer( int h, int m , int s){
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
        
    }
    

    public void tick(){
        
        if (seconds == 60 && minutes == 60 && hours == 24) {
            this.seconds = 00;
            this.minutes = 00;
            this.hours = 00;
        }
        else if(seconds == 60 && minutes== 60 && hours!= 24){
            this.seconds = 00;
            this.minutes = 00;
            this.hours = this.hours+1;
        }
        else if(seconds == 60 && minutes!= 60 && hours!= 24){
            this.seconds = 00;
            this.minutes = this.minutes+1;
            this.hours = this.hours;
        }
        else{
             seconds++;
        }
      Notify();
    } 



}
abstract class Observer{
    public void update(Subject sub){
    }

}
class AnalogClock  extends Observer{
    public void update(Subject sub){
       draw();
       ClockTimer clockTimer = (ClockTimer) sub;
        System.out.println("Analog Clock: " + clockTimer.hours + ":" + clockTimer.minutes + ":" + clockTimer.seconds );

    }
    public void draw(){
        System.out.println("Drawing an Analog Clock" );
    }


}
class DigitalClock extends Observer{
      public void update(Subject sub){
       draw();
       ClockTimer clockTimer = (ClockTimer) sub;
        System.out.println("Digital Clock: " + clockTimer.hours + ":" + clockTimer.minutes + ":" + clockTimer.seconds);
    }
     public void draw(){
        System.out.println("Drawing a Digital Clock" );
    }

}