package org.coretechies.model;

//important packages that should be import
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {
    //Contact attributes
    private String name;
    private long number;
    public static List<Contact> contacts1 = new ArrayList<>();

    //empty constructor
    public Contact() {
    }

    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
    }

    // getter
    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }
}
