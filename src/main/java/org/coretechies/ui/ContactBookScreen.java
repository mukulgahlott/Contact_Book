package org.coretechies.ui;

//important packages that should be import

import org.coretechies.model.UpdateContacts;
import org.coretechies.util.Utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class ContactBookScreen {

    public static String key;
    public static JFrame mainFrame;
    protected JPanel contactPanel;
    public static JTable contactTable;
    public JButton addNewCont;
    protected JLabel searchL;
    public JTextField searchT;
    public static DefaultTableModel tableModel;

    // build a java frame
    public void contactHomeFrame() {
        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void searchUi() {

//    build search menu
        searchL = new JLabel("Search");
        mainFrame.add(searchL);
        searchT = new JTextField(16);
        mainFrame.add(searchT);
        JButton search = new JButton("find");
        mainFrame.add(search);
        key = searchT.getText();
//    add Action listener at click on search Button
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility.search();
            }
        });
    }

    //   build Contact panel to see saved Contacts
    public void contactTablePanel() {
        contactPanel = new JPanel();
        contactPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Contacts",
                TitledBorder.LEFT, TitledBorder.TOP));
        mainFrame.add(contactPanel);
        UpdateContacts printTableContacts = new UpdateContacts();
        printTableContacts.printContacts();
        // Step 4: Create the table with the table model
        contactTable = new JTable(tableModel);
        // Step 5: Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(contactTable);
        contactPanel.add(scrollPane);
    }

    // build a Button to open Add new Contacts
    public void addContact() {
        addNewCont = new JButton();
        addNewCont.setText("Add new contact");
        mainFrame.add(addNewCont);
        mainFrame.setVisible(true);
        //  set an Action Listener to open AddNewContactScreen
        addNewCont.addActionListener(e -> {
            AddNewContactScreen addContactScreen = new AddNewContactScreen();
            addContactScreen.showAddNewContactScreen();

        });
    }

    // function to Show ContactBookScreen
    public void showContactScreen() {
        contactHomeFrame();
        searchUi();
        contactTablePanel();
        addContact();
    }


}