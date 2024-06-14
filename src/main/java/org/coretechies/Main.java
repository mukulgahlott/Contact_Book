package org.coretechies;

import org.coretechies.model.Contact;
import org.coretechies.ui.ContactBookScreen;

import static org.coretechies.model.UpdateContacts.contact1;


public class Main {

    public static void main(String[] args) {

        // load contact details
        Contact contact = new Contact();
        contact1 = contact.loadData();
        contact.saveData(contact1);

        // load contacts book screen
        ContactBookScreen contactScreen = new ContactBookScreen();
        contactScreen.showContactScreen();

    }
}