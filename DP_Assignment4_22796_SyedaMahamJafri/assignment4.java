//Syeda Maham Jafri
//Design Pattern Assignment 4: State Pattern

import java.util.Scanner;

public class assignment4{
    public static void main(String[] args){
    
    Context context = new Context();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Do you already have an account? Answer with yes or no ");
        String Accountexists = scanner.nextLine();
        
        // if the user has an account then they just need to login into their account
        if ("yes".equalsIgnoreCase(Accountexists)) {
            LoginScreenState login = new LoginScreenState();
            login.doAction(context);
        } 
        // else if they dont have an account they need to create one hence we move them to the register screen and then to login screen
        else {
            RegisterScreenState register = new RegisterScreenState();
            register.doAction(context);
            LoginScreenState login = new LoginScreenState();
            login.doAction(context);
        }

        // Once logged in the user can now Search for products
        SearchScreenState SearchingProduct = new SearchScreenState();
        SearchingProduct.doAction(context);

        // the user can also view the items that are shown on the screen
        ViewItemScreenState ViewItem = new ViewItemScreenState();
        ViewItem.doAction(context);

        // User Adding an item to the cart.
        System.out.println("Do you want to add this item to your cart? Yes or No?");
        String ItemAdded = scanner.nextLine();
        if ("yes".equalsIgnoreCase(ItemAdded)) {
            AddToCartScreenState AddToCart = new AddToCartScreenState();
            AddToCart.doAction(context);
        }

        // User Viewing the items in the cart
        CartViewScreenState CartView = new CartViewScreenState();
        CartView.doAction(context);

        // Removing an item from the cart.
        System.out.println("Do you want to remove an item from your cart? Yes or No?");
        String ItemRemoved = scanner.nextLine();
        if ("yes".equalsIgnoreCase(ItemRemoved)) {
            RemoveItemScreenState RemoveItem = new RemoveItemScreenState();
            RemoveItem.doAction(context);
        }

        // The user is Proceeding to checkout state
        CheckoutScreenState checkout = new CheckoutScreenState();
        checkout.doAction(context);

        System.out.println("Current state: " + context.getState().toString());
        scanner.close();
    }
}


interface State {
public void doAction(Context context);
}
class Context{
private State state;

public Context(){
 state = null;
}

public void setState(State state){
    this.state = state;
}

public State getState(){
    return this.state;
}
}

class RegisterScreenState implements State{
    public void doAction(Context context){
        System.out.println("The user is registering");
        context.setState(this);
    }

    public String toString(){
        return "Register State";
    }
}

class LoginScreenState implements State{
    public void doAction(Context context){
        System.out.println("The user is logging into their account");
        context.setState(this);
    }

    public String toString(){
        return "Login State";
    }
}

class SearchScreenState implements State{
    public void doAction(Context context){
        System.out.println("The user is searching for the product");
        context.setState(this);
    }

    public String toString(){
        return "Search Screen State";
    }
}

class AddToCartScreenState implements State {
    public void doAction(Context context) {
        System.out.println("The user might be adding an item to their cart");
        context.setState(this);
    }

    public String toString() {
        return "Add To Cart  State";
    }
}

class RemoveItemScreenState implements State {
    public void doAction(Context context) {
        System.out.println("The user has removed an item from their cart");
        context.setState(this);
    }

    public String toString() {
        return "Remove Item State.";
    }
}

class CartViewScreenState implements State {
    public void doAction(Context context) {
        System.out.println("The user is viewing the status of their cart");
        context.setState(this);
    }

    public String toString() {
        return "Cart View State.";
    }
}

class ViewItemScreenState implements State {
    public void doAction(Context context) {
        System.out.println("The user is viewing an item");
        context.setState(this);
    }

    public String toString() {
        return "View Item State";
    }
}

class CheckoutScreenState implements State {
    public void doAction(Context context) {
        System.out.println("The user is checking out");
        context.setState(this);
    }

    public String toString() {
        return "Checkout State.";
    }
}