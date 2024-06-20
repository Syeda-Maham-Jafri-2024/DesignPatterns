//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public abstract class ColdDrink implements Item {
  Packing type;    
  public ColdDrink(Packing decide){
     this.type = decide;
  }  
 @Override public Packing packing() {
  return type;
 }
 @Override public abstract float price();
 @Override public abstract String name();
}
