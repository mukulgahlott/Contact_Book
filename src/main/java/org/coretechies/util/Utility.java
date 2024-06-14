package org.coretechies.util;

import org.coretechies.model.Contact;
import org.coretechies.ui.ContactBookScreen;

import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.List;

public class Utility {

    public static void sort(List<Contact> contacts1) {
        contacts1.sort(Comparator.comparing(Contact::getName));

    }


}
