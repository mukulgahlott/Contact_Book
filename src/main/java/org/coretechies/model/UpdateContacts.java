package org.coretechies.model;

//important packages that should be import
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.coretechies.data.DataStorage;
import static org.coretechies.ui.AddNewContactScreen.nameT;
import static org.coretechies.ui.AddNewContactScreen.numberT;
import org.coretechies.ui.ContactBookScreen;
import static org.coretechies.ui.ContactBookScreen.contactTable;
import static org.coretechies.ui.ContactBookScreen.mainFrame;
import static org.coretechies.ui.ContactBookScreen.tableModel;
import org.coretechies.util.Utility;

public class UpdateContacts {
    String name;
    long number;
    String[] columnNames;
    Object[] rowData;
    public static List<Contact> contact1 = new ArrayList<>();

    // print the Contacts in Contact table
    public void printContacts() {
        // Create the table model and set column names
        columnNames = new String[] { "NAME", "NUMBER" };
        tableModel = new DefaultTableModel(columnNames, 0);
        Utility.sort(contact1);
        // Add data to the table model
        for (Contact person : contact1) {
            rowData = new Object[] { person.getName(), person.getNumber() };
            tableModel.addRow(rowData);
            System.out.println(person.getName());
        }
        // Set the updated table model to the contactTable
        contactTable.setModel(tableModel);
    }

    // Adding new Contacts
    public void addNewContacts() {
        name = nameT.getText();
        try {
            number = Long.parseLong(numberT.getText());
            contact1.add(new Contact(name, number));
            // Save input data in contact1 list
            DataStorage contact = DataStorage.getInstance();
            contact.saveData(contact1);
            // Refresh the contact table
            ContactBookScreen.refreshContactTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Enter valid details");
        }
    }
}
