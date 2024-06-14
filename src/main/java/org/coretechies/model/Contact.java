package org.coretechies.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

public class Contact implements Serializable {
    private static final String FILENAME = "contacts.txt";
    private List<Contact> contacts1 = new ArrayList<>();

    public Contact() {
    }

    private String name;
    private int number;



    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // getter
    public String getName() {
        return name;

    }

    public int getNumber() {
        return number;
    }

    // Load existing user details
    public  List<Contact> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            contacts1 = (List<Contact>) ois.readObject();
            System.out.println("Users loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing users found. Creating a new user database.");
        }
        return contacts1;
    }
    // Save user details into file
    public  void saveData(List<Contact> contacts1) {

        // covert object into output stream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(contacts1);

        } catch (IOException e) {
            System.out.println("Error occurred while saving users: " + e.getMessage());
        }
    }


}
