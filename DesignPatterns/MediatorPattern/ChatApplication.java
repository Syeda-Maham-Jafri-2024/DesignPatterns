// You are developing a chat application that allows users to communicate with each other in real-time. The application supports 
// multiple chat rooms, and users can join or leave rooms dynamically. The system must ensure that messages sent by one user are 
//received by all other users in the same chat room. Additionally, users should be able to send private messages to specific individuals.

// Requirements:

// There should be a central chat mediator responsible for managing communication between users.
// The chat mediator should provide methods for users to send messages, join or leave chat rooms, and send private messages.
// Users can be of different types, such as regular users and administrators, each with specific permissions.
// The system must be scalable to support an arbitrary number of users and chat rooms.
// The chat mediator should handle the routing of messages between users and enforce user permissions.
// Challenges:

// The chat application must handle dynamic creation and deletion of chat rooms and users.
// It should be possible to extend the system by adding new user types or chat features without modifying existing code.
// Tasks:

// Identify the design pattern that best addresses the challenges and requirements outlined in this scenario.
// Implement the necessary class or classes for the chosen design pattern to ensure flexible communication management.
// Provide code snippets demonstrating how different users in the chat application can communicate using the mediator pattern.
import java.util.ArrayList;
import java.util.List;
public class ChatApplication{
    public static void main(String[] args){
       ChatMediator mediator = new ChatMediator1();

        User rachel = new RegularUser(mediator, "Rachel");
        User sam = new RegularUser(mediator, "Sam");
        User admin = new AdminUser(mediator, "Admin");

        mediator.addUser(rachel);
        mediator.addUser(sam);
        mediator.addUser(admin);

        rachel.sendMessage("Hello, everyone!");
        System.out.println();
        admin.sendMessage("Welcome, users!");
        System.out.println();
        sam.sendMessage("Thanks for the welcome!");
        System.out.println();
        ((AdminUser) admin).KickUser(rachel);
    }
}
interface ChatMediator {
    void sendMessage(User sender, String message);
    void addUser(User user);
    void removeUser(User user);
}

// Concrete Mediator
class ChatMediator1 implements ChatMediator {
    private List<User> users;

    public ChatMediator1() {
        this.users = new ArrayList<>();
    }
    public void sendMessage(User sender, String message) {
        for (User user : users) {
            // Broadcast the message to all users except the sender
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
}
interface User{
    public String name();
    public void sendMessage(String Message);
    public void receiveMessage(String Message);
}
class RegularUser implements User{
    private ChatMediator mediator;
    private String username;

    public RegularUser(ChatMediator med, String name){
        this.mediator = med;
        this.username = name;
    }
    public String name(){
        return this.username;
    } 
    public void sendMessage(String Message){
      System.out.println(name() + " has send the message: " + Message);
      mediator.sendMessage(this,Message);
    }
    public void receiveMessage(String Message){
       System.out.println(name() + " has received the message: " + Message); 
    }
}
class AdminUser implements User{
    private ChatMediator mediator;
    private String username;

    public AdminUser(ChatMediator med, String name){
        this.mediator = med;
        this.username = name;
    }
    public String name(){
        return this.username;
    } 
    public void sendMessage(String Message){
      System.out.println(name() + " has send the message: " + Message );
      mediator.sendMessage(this,Message);
    }
    public void receiveMessage(String Message){
       System.out.println(name() + " has received the message: " + Message); 
    }
    public void KickUser(User user){
        System.out.println(name() + " has kicked the user: " + user.name()); 
        mediator.removeUser(user);
    }
}