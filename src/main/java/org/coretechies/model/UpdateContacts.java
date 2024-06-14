package org.coretechies.model;

import org.coretechies.ui.ContactBookScreen;
import org.coretechies.util.Utility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.coretechies.ui.AddNewContactScreen.*;
import static org.coretechies.ui.ContactBookScreen.*;

public class UpdateContacts {
    String name;
    int number;
    String[] columnNames;
    Object[] rowData;
    public static List<Contact> contact1 = new ArrayList<>();


    // print the Contacts in Contact table
    public void printContacts() {
        // Step 3: Create the table model and set column names
        columnNames = new String[]{"NAME", "NUMBER"};
        tableModel = new DefaultTableModel(columnNames, 0);
        Utility.sort(contact1);
        // Add data to the table model
        for (Contact person : contact1) {
            rowData = new Object[]{person.getName(), person.getNumber()};
            tableModel.addRow(rowData);
        }


    }

    //   adding new Contacts
    public void addNewContacts() {
        name = nameT.getText();
        System.out.println(name);
        try {
            number = Integer.parseInt(numberT.getText());
            contact1.add(new Contact(name, number));
             //  repaint / refresh the
            tableModel = (DefaultTableModel)contactTable.getModel();
//            tableModel.setRowCount(0);
            printContacts();
            //  save input data in contact1 list
            Contact contact = new Contact();
            contact.saveData(contact1);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Enter valid details");
        }


    }

    // search the Contacts and update the table
    public static void search() {
        String[] header = {"NAME", "NUMBER"};
        DefaultTableModel tableModel = new DefaultTableModel(header, 0);
        for (Contact c : contact1) {
            if (c.getName().contains(ContactBookScreen.key)) {
                Object[] rowData = {c.getName(), c.getNumber()};
                tableModel.addRow(rowData);


            } else {
                System.out.println("Contact not found");
            }


        }

    }
}
