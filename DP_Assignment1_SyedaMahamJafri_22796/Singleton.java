//Name: Syeda Maham Jafri
//ERP:22796
//Design Pattern Assignment 1, Due: 30 September

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Singleton {
    private static Properties prop = new Properties(); 
    private static int length;
    private static int index;
    private static List<Singleton> Listofinstances = new ArrayList<>();
    private static int max_num_of_instances;
    private static int instanceIndex = 0;
    static {

        try {
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            length = Integer.parseInt(prop.getProperty("n"));
            setMaxInstances(length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (Listofinstances.size() < max_num_of_instances) {
            Singleton instance = new Singleton();
            Listofinstances.add(instance);
            return instance;
        } else {
            index = instanceIndex % max_num_of_instances;
            instanceIndex++;
            return Listofinstances.get(index);
        }
    }

    public static void setMaxInstances(int n) {
        max_num_of_instances = n;
    }

    public static int getInstanceCount() {
        return Listofinstances.size();
    }

   
}