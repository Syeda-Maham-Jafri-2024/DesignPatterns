//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public class BuilderPatternDemo {
 public static void main(String[] args) {
  MealBuilder mealBuilder = new MealBuilder();
  Meal vegMeal = mealBuilder.prepareVegMealwithCanCoke();
  
  System.out.println("Veg Meal with Can Coke");
   vegMeal.showItems();
  System.out.println("Total Cost: " + vegMeal.getCost());

  Meal nonVegMeal = mealBuilder.prepareNonVegMealwithBottlePepsi();
  System.out.println("\n\nNon-Veg Meal with Bottle Pepsi");
  nonVegMeal.showItems();
  System.out.println("Total Cost: " + nonVegMeal.getCost());

  Meal nonvegwithMayo = mealBuilder.prepareNonVegMealwithBottlePepsiandMayofries();
  System.out.println("\n\nNon-Veg Meal with Bottle Pepsi and Mayo Fries");
  nonvegwithMayo.showItems();
  System.out.println("Total Cost: " + nonvegwithMayo.getCost());

  Meal nonvegwithMasala = mealBuilder.prepareNonVegMealwithCanPepsiandMasalafries();
  System.out.println("\n\nNon-Veg Meal with Can Pepsi and Masala Fries");
  nonvegwithMasala.showItems();
  System.out.println("Total Cost: " + nonvegwithMasala.getCost());

}
} 