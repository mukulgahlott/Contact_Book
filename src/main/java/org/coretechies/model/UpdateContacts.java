package org.coretechies.model;

//important packages that should be import
import org.coretechies.data.DataStorage;
import org.coretechies.util.Utility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import static org.coretechies.ui.AddNewContactScreen.*;
import static org.coretechies.ui.ContactBookScreen.*;

public class UpdateContacts {
    String name;
    long number;
    String[] columnNames;
    Object[] rowData;
    public static List<Contact> contact1 = new ArrayList<>();

    // print the Contacts in Contact table
    public void printContacts() {
        //  Create the table model and set column names
        columnNames = new String[]{"NAME", "NUMBER"};
        tableModel = new DefaultTableModel(columnNames, 0);
        Utility.sort(contact1);
        // Add data to the table model
        for (Contact person : contact1) {
            rowData = new Object[]{person.getName(), person.getNumber()};
            tableModel.addRow(rowData);
            System.out.println(person.getName());
        }
    }

    //   adding new Contacts
    public void addNewContacts() {
        name = nameT.getText();
        try {
            number = Long.parseLong(numberT.getText());
            contact1.add(new Contact(name, number));
            //  repaint / refresh the
            //  tableModel = (DefaultTableModel) contactTable.getModel();
            //  printContacts();
            //  tableModel.fireTableDataChanged();
            //  save input data in contact1 list
            DataStorage contact = DataStorage.getInstance();
            contact.saveData(contact1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Enter valid details");
        }
    }

}
