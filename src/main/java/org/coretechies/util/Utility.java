package org.coretechies.util;

//important packages that should be import
import org.coretechies.model.Contact;
import org.coretechies.ui.ContactBookScreen;

import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.coretechies.model.UpdateContacts.*;
import static org.coretechies.ui.ContactBookScreen.*;

public class Utility {

    // sort the table contacts
    public static void sort(List<Contact> contacts1) {
        contacts1.sort(Comparator.comparing(Contact::getName));

    }

    // search the Contacts and update the table
    public static void search() {
        String[] header = {"NAME", "NUMBER"};
        tableModel = new DefaultTableModel(header, 0);
        DefaultTableModel searchTableModal = new DefaultTableModel();
        for (Contact c : contact1) {
            if (c.getName().contains(ContactBookScreen.key)) {
                Object[] rowData = {c.getName(), c.getNumber()};
                searchTableModal.addRow(rowData);
                System.out.println(Arrays.toString(rowData));
            }
        }
        if (searchTableModal.getRowCount() == 0) {
            System.out.println("Contact not found");
        } else {
            contactTable.setModel(searchTableModal);
        }

    }
}
