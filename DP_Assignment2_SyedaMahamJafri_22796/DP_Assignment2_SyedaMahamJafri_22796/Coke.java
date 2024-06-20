//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public class Coke extends ColdDrink {
 public Coke(Packing decide) {
        super(decide);
        
    }
@Override public float price() { 
     if (super.packing().pack() == "Bottle"){return 30.0f; }
     else if(super.packing().pack() == "Can"){return 35.0f; }
    return 0;
 }     
 @Override public String name() { return "Coke"; }
}
