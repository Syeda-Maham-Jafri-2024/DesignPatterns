// You are working on a coffee shop application where customers can order different types of coffee with 
// optional extras. The system needs to allow customers to customize their coffee orders by adding various
// extras such as whipped cream, caramel, or flavored syrups.

// Requirements:
// Implement a decorator pattern to enhance the coffee customization functionality.
// Coffee should be the base component, and extras should be decorators.
// Customers should be able to add multiple extras to their coffee orders.
// It should be possible to introduce new extras without modifying existing code.

// Challenges:
// Ensure that the decorator pattern allows for flexible and dynamic customization of coffee orders.
// Design the system to handle the pricing of coffee with different combinations of extras.

// Tasks:
// Identify the design pattern that best addresses the challenges and requirements outlined in this 
//scenario.
// Implement the necessary classes for the chosen design pattern to enable flexible customization of coffee orders.
// Provide code snippets demonstrating how customers can order coffee with various extras using the decorator pattern.


public class CoffeeShop{
    public static void main(String[] args){
      Coffee ordered = new ChocolateSyrup(new WhippedCream( new BasicCoffee()));

      System.out.println("Ingredients: " + ordered.getCoffeeDescription());
      System.out.println("Cost: " + ordered.getCoffeeCost());
    }
}

interface Coffee{
   
   public String getCoffeeDescription();
   public double getCoffeeCost();
}

class BasicCoffee implements Coffee{
    
    public BasicCoffee(){
        System.out.println("Basic Coffee");
    }
    public String getCoffeeDescription(){
        return "Plain Coffee ";
    }

    public double getCoffeeCost(){
        return 0.90;
    }
}

abstract class Extras implements Coffee{
    protected Coffee coffee;

    public Extras(Coffee addon){
        coffee = addon;
     }

    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription();
    }

    public double getCoffeeCost(){
        return coffee.getCoffeeCost();
    }
}

class WhippedCream extends Extras{

    public WhippedCream(Coffee addon){
        super(addon);
        System.out.println("Adding Whipped Cream to Coffee");
     }

    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription() + ", whipped cream";
    }

    public double getCoffeeCost(){
        return coffee.getCoffeeCost() + 0.30;
    }
}

class Caramel extends Extras{

    public Caramel(Coffee addon){
        super(addon);
        System.out.println("Adding Caramel to Coffee");
     }

    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription() + ", caramel ";
    }

    public double getCoffeeCost(){
        return coffee.getCoffeeCost() + 0.25;
    }
    
}

class ChocolateSyrup extends Extras{
    public ChocolateSyrup(Coffee addon){
        super(addon);
        System.out.println("Adding Chocolate Syrup to Coffee");
     }

    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription() + ", chocolate syrup ";
    }

    public double getCoffeeCost(){
        return coffee.getCoffeeCost() + 0.35;
    }
    
    
}

class VanillaSyrup extends Extras{
     public VanillaSyrup(Coffee addon){
        super(addon);
        System.out.println("Adding Vanilla Syrup to Coffee");
     }

    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription() + ", vanilla syrup ";
    }

    public double getCoffeeCost(){
        return coffee.getCoffeeCost() + 0.30;
    }
    

}