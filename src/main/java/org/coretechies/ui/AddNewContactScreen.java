package org.coretechies.ui;

//important packages that should be import
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.coretechies.model.UpdateContacts;

public class AddNewContactScreen {

    JFrame addContactF;
    JLabel nameL, numberL;
    public static JTextField nameT, numberT;
    JButton saveContact;

    public void addContactFrame() {

        addContactF = new JFrame();
        addContactF.setVisible(true);
        addContactF.setLocation(400, 20);
        addContactF.setSize(250, 340);
        addContactF.setLayout(new FlowLayout());
    }

    public void enterContactDetails() {

        nameL = new JLabel("Name :   ");
        numberL = new JLabel("Number :");

        nameT = new JTextField(13);
        numberT = new JTextField(13);

        addContactF.add(nameL);
        addContactF.add(nameT);
        addContactF.add(numberL);
        addContactF.add(numberT);

    }

    public void saveContactButton() {
        saveContact = new JButton("save");
        addContactF.add(saveContact);

        saveContact.addActionListener(e -> {
            UpdateContacts perform = new UpdateContacts();
            perform.addNewContacts();
            addContactF.dispose();

        });
    }

    public void showAddNewContactScreen() {

        addContactFrame();
        enterContactDetails();
        saveContactButton();

    }

}
