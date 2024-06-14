package org.coretechies;

//important packages that should be import
import org.coretechies.data.DataStorage;
import org.coretechies.ui.ContactBookScreen;

import static org.coretechies.model.UpdateContacts.contact1;


public class Main {

    public static void main(String[] args) {

        // load contact details
        DataStorage contact = DataStorage.getInstance();
        contact1 = contact.loadData();
        contact.saveData(contact1);

        // Show contacts book screen
        ContactBookScreen contactScreen = new ContactBookScreen();
        contactScreen.showContactScreen();

    }
}