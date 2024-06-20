// You are developing an order processing system for an e-commerce platform. The system needs to handle different states of an order,
// including processing, shipped, delivered, and canceled. Each state requires specific actions and transitions, and the system should
// allow for easy addition of new order states in the future.

// Requirements:

// There should be a central order state manager responsible for handling the state of each order.
// The order state manager should provide methods to transition an order between states, such as processing, shipped, delivered, and canceled.
// Each order state may have specific actions associated with it, such as sending confirmation emails or updating inventory.
// The system must be flexible enough to accommodate new order states without altering existing code.
// Orders should seamlessly transition between states based on specific conditions, such as payment confirmation or item availability.
// Challenges:

// The order processing system must handle various states and their associated actions.
// It should be possible to introduce new order states without modifying existing code.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary class or classes for the chosen design pattern to ensure flexible order state management.
// Provide code snippets demonstrating how different parts of the application can transition orders between states using the state pattern.
import java.util.Scanner;
public class OrderProcessing{
  public static void main(String[] args){
    OrderManager manager = new OrderManager();
        Scanner sc= new Scanner(System.in); 
        System.out.print("Has any order been received? ");
        String str= sc.nextLine(); 
        if("Yes".equals(str)){
           OrderState receive = new received();
           receive.sendConfirmationEmail();
           receive.updateInventory(200);
           System.out.println(receive.manager.inventoryammount);
        }
        else{
            System.out.println("Waiting for the order to be received.");
        }

  }
}
class OrderManager{
    // OrderState hasbeenshipped;
    // OrderState hasbeenprocessed;
    // OrderState hasbeendelivered;
    // OrderState hasbeencancelled;

    OrderState currentstate;
    int inventoryammount = 1000;
    // public OrderManager(){
    //     this.hasbeenshipped = new shipped();
    //     this.hasbeenreceived = new received();
    //     this.hasbeendelivered = new delivered();
    //     this.hasbeencancelled = new cancelled();
        

    // }
    public void setOrderState(OrderState newstate){
        currentstate = newstate;
    }
    public void setInventory(int ammount){
     inventoryammount = ammount;
    }
    
}
interface OrderState{
    void sendConfirmationEmail();
    void updateInventory();


}
class received implements OrderState{
    OrderManager manager;
    public void sendConfirmationEmail(){
        System.out.println("The confirmation email for receiving the order has been sent");
    }
    public void updateInventory(int requestreceived){
        manager.setInventory(manager.inventoryammount - requestreceived );

    }
}
class processing implements OrderState{
    public void sendConfirmationEmail(){
        System.out.println("The confirmation email for order processing has been sent");
    }
    public void updateInventory(int requestreceived){
       System.out.println("The inventory has been updated");

    }
}
class shipped implements OrderState{
    public void sendConfirmationEmail(){
        System.out.println("The confirmation email for shipment the order has been sent");
    }
      public void updateInventory(int requestreceived){
       System.out.println("The inventory has been updated");

    }
}
class delivered implements OrderState{
    public void sendConfirmationEmail(){
        System.out.println("The confirmation email for the order being delivered has been sent");
    }
      public void updateInventory(int requestreceived){
       System.out.println("The inventory has been updated");

    }
}
class cancelled implements OrderState{
    public void sendConfirmationEmail(){
        System.out.println("The confirmation email for cancellation of order has been sent");
    }
    public void updateInventory(int cancelledamount){
        manager.setInventory(manager.inventoryammount + cancelledamount );

    }
}