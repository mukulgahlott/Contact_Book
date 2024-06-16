package org.coretechies.util;

//important packages that should be import
import java.util.Comparator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.coretechies.model.Contact;
import static org.coretechies.model.UpdateContacts.contact1;
import static org.coretechies.ui.ContactBookScreen.contactTable;

public class Utility {

    // sort the table contacts
    public static void sort(List<Contact> contacts1) {
        contacts1.sort(Comparator.comparing(Contact::getName));
    }

    // search the Contacts and update the table
    public static void search(String key) {
        String[] header = { "NAME", "NUMBER" };
        DefaultTableModel searchTableModel = new DefaultTableModel(header, 0);
        for (Contact c : contact1) {
            if (c.getName().contains(key)) {
                Object[] rowData = { c.getName(), c.getNumber() };
                searchTableModel.addRow(rowData);
            }
        }
        if (searchTableModel.getRowCount() == 0) {
            System.out.println("Contact not found");
        }
        contactTable.setModel(searchTableModel);
    }
}
