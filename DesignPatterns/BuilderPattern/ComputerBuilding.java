// You are developing a system for configuring custom computers based on user preferences. Each computer can have various components,
// such as a processor, memory, storage, and graphics card. The system should allow users to build their computer configurations by 
//selecting components and specifying options. Additionally, the system should support the addition of new computer components in the
// future.

// Requirements:

// There should be a central computer builder responsible for constructing different types of computers.
// The computer builder should provide methods to add a processor, choose memory options, select storage, add a graphics card, and finalize the computer configuration.
// Each computer component may have specific options and configurations, such as choosing from a list of processors or specifying storage capacity.
// The system must be flexible enough to accommodate new computer components without altering existing code.
// Computer configurations should be built based on user selections, and the configuration process should guide users through the options.
// Challenges:

// The computer configuration system must handle variations in computer components and their configurations.
// It should be possible to introduce new computer components without modifying existing code.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary class or classes for the chosen design pattern to ensure flexible computer configuration.
// Provide code snippets demonstrating how different parts of the application can construct computer configurations using the builder pattern.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ComputerBuilding{
    public static void main(String[] args){
        computerBuilder myComputer = new computerBuilder();

        computer reqcomp = myComputer.getComputer();
        reqcomp.showitem();

    }
}
class computerBuilder{
        
        Processor p;
        Storage s;
        Memory m ;
        GraphicCard g;
        computer c = new computer();
        
        public computerBuilder(){
        Scanner sc= new Scanner(System.in); 
        System.out.print("Do you want a processor? ");
        String pans= sc.nextLine(); 
        if("Yes".equals(pans)){
            System.out.print("Which one do you want? Microcontroller, MicroProcessor, Embedded? ");
            String ptypeans= sc.nextLine(); 
            if("Microcontroller".equals(ptypeans)){
                this.p = new Microcontroller();
            }
            else if("MicroProcessor".equals(ptypeans)){
                this.p = new MicroProcessor();
            }
            else if("Embedded".equals(ptypeans)){
                this.p = new EmbeddedProcessor();
            }
            else{
                System.out.println("Error! the processor does not exists");
            }
        }
        System.out.print("Do you want a memory space? ");
        String mans= sc.nextLine(); 
        if("Yes".equals(mans)){
           System.out.print("How much memory do you want? 4GB, 8GB, 16GB?");
           String mtypeans= sc.nextLine();
             if("4GB".equals(mtypeans)){
                this.m = new FourGB();
            }
            else if("8GB".equals(mtypeans)){
                this.m = new EightGB();
            }
            else if("16GB".equals(mtypeans)){
                this.m = new sixteenGB();
            }
            else{
                System.out.println("Error! the memory req does not exists");
            }
        }
        System.out.print("Do you want a storage size? ");
        String sans= sc.nextLine(); 
        if("Yes".equals(sans)){
           System.out.print("How much storage do you want? 120GB, 240GB?");
           String stypeans= sc.nextLine();
             if("120GB".equals(stypeans)){
                this.s = new hundredtwentyGB();
            }
            else if("240GB".equals(stypeans)){
                this.s = new twohundredfortyGB();
            }
            else{
                System.out.println("Error! the storage req does not exists");
            }
        } 
        System.out.print("Do you want a graphic card? ");
        String gans= sc.nextLine(); 
        if("Yes".equals(gans)){
           System.out.print("Which one do you wnat? Integrated or Dedicated?");
           String gtypeans= sc.nextLine();
             if("Integrated".equals(gtypeans)){
                this.g = new integrated();
            }
            else if("Dedicated".equals(gtypeans)){
                this.g = new dedicated();
            }
            else{
                System.out.println("Error! the graphic card does not exists");
            }
        }
        }

        public computer getComputer(){
         c.additem(this.p);
         c.additem(this.m);
         c.additem(this.s);
         c.additem(this.g);

         return c;
        }
}
interface Item {
 public String getDescription();
 }

class computer{
    private List<Item> items = new ArrayList<Item>();

    public void additem(Item itm){
        items.add(itm);
    }
    public void showitem(){
        for(Item a: items){
            System.out.println(a.getDescription());
        }
    }
    
}
abstract class Processor implements Item{
    public abstract String getDescription();
}
class Microcontroller extends Processor{
    public String getDescription(){
     return "Microcontroller";}
}
class MicroProcessor extends Processor{
   public String getDescription(){
        return "MicroProcessor";}
}
class EmbeddedProcessor extends Processor{
   public String getDescription(){
     return "EmbeddedProcessor";}
}

abstract class Memory implements Item{
    public abstract String getDescription();
}
class FourGB extends Memory{
     public String getDescription(){
        return "MemorySize: 4GB";
    }
}
class EightGB extends Memory{
      public String getDescription(){
        return "MemorySize: 8GB";
    }
}
class sixteenGB extends Memory{
      public String getDescription(){
        return "MemorySize: 16GB";
    }
}

abstract class Storage implements Item{
    public abstract String getDescription();
}
class hundredtwentyGB extends Storage{
     public String getDescription(){
    return "Storage Space: 120 GB";
   }
}
class twohundredfortyGB extends Storage{
    public String getDescription(){
    return "Storage Space: 240 GB";
   }
}
abstract class GraphicCard implements Item{
   public abstract String getDescription();
}
class integrated extends GraphicCard{
      public String getDescription(){
        return "Integrated";
    }
}
class dedicated extends GraphicCard{
      public String getDescription(){
        return "Dedicated";
    }
}