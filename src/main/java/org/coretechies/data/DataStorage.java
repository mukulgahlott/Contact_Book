package org.coretechies.data;

//important packages that should be import
import org.coretechies.model.Contact;

import java.io.*;
import java.util.List;

import static org.coretechies.model.Contact.contacts1;

// Singleton class
public class DataStorage implements Serializable {
    private static DataStorage instance;
    private static final String FILENAME = "contacts.txt";

    //    Empty constructor
    private DataStorage() {
    }

    public static DataStorage getInstance() {

        if (instance == null) {
            // if instance is null, initialize
            instance = new DataStorage();
        }
        return instance;
    }

    // Load existing user details
    public List<Contact> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            contacts1 = (List<Contact>) ois.readObject();
            System.out.println("Users loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing users found. Creating a new user database.");
        }
        return contacts1;
    }

    // Save user details into file
    public void saveData(List<Contact> contacts1) {
        // covert object into output stream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(contacts1);

        } catch (IOException e) {
            System.out.println("Error occurred while saving users: " + e.getMessage());
        }
    }
}
