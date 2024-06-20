//Syeda Maham Jafri 22796
//Design Pattern Assignment2
public class MealBuilder {
 
 public Meal prepareVegMealwithCanCoke () {
  Meal meal = new Meal();
  meal.addItem(new VegBurger());
  meal.addItem(new Coke(new Can()));
  return meal;
 }
 public Meal prepareNonVegMealwithBottlePepsi () {
  Meal meal = new Meal();
  meal.addItem(new ChickenBurger());
  meal.addItem(new Pepsi(new Bottle()));
  return meal;
 }
 public Meal prepareNonVegMealwithBottlePepsiandMayofries() {
  Meal meal = new Meal();
  meal.addItem(new ChickenBurger());
  meal.addItem(new Mayofries());
  meal.addItem(new Pepsi(new Bottle()));
  return meal;
 }
  public Meal prepareNonVegMealwithCanPepsiandMasalafries() {
  Meal meal = new Meal();
  meal.addItem(new ChickenBurger());
  meal.addItem(new Masalafries());
  meal.addItem(new Pepsi(new Can()));
  return meal;
 }
}