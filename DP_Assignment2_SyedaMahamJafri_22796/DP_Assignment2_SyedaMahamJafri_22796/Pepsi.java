//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public class Pepsi extends ColdDrink{
 public Pepsi(Packing decide) {
        super(decide); 
    }
@Override public float price() { 
     if (super.packing().pack() == "Bottle"){return 30.0f; }
     else if(super.packing().pack() == "Can"){return 35.0f; }
    return 0;
 }     
 @Override public String name() { return "Pepsi"; }
}

