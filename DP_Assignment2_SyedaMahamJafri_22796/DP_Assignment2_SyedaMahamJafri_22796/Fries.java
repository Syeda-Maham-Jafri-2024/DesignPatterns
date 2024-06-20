//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public abstract class Fries implements Item{
    @Override public Packing packing() {
        return new Wrapper();
        }
     @Override public abstract float price();
     @Override public abstract String name();
}

