//Name: Syeda Maham Jafri
//ERP:22796
//Design Pattern Assignment 1, Due: 30 September
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties prop = new Properties();
        int length;
        try {
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            length = Integer.parseInt(prop.getProperty("n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i=1; i<=10;i++){
            Singleton instance = Singleton.getInstance();
           
            System.out.println("Instance " + i + ": " + instance);

        }

        System.out.println("Instance count: " + Singleton.getInstanceCount());
    }
}
