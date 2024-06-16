package org.coretechies.ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.coretechies.model.UpdateContacts;
import org.coretechies.util.Utility;

public class ContactBookScreen {

    public static String key;
    public static JFrame mainFrame;
    protected JPanel contactPanel;
    public static JTable contactTable;
    public JButton addNewCont;
    protected JLabel searchL;
    public JTextField searchT;
    public static DefaultTableModel tableModel;

    // Build the main frame
    public void contactHomeFrame() {
        mainFrame = new JFrame("Contact Book");
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(null); // Use absolute positioning
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Build the search UI
    public void searchUi() {
        searchL = new JLabel("Search:");
        searchL.setBounds(20, 20, 60, 25);
        mainFrame.add(searchL);

        searchT = new JTextField();
        searchT.setBounds(90, 20, 200, 25);
        mainFrame.add(searchT);

        // Add DocumentListener to the search text field
        searchT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchAndUpdate();
            }

            private void searchAndUpdate() {
                key = searchT.getText();
                Utility.search(key);
            }
        });
    }

    // Build contact panel to display saved contacts
    public void contactTablePanel() {
        contactPanel = new JPanel();
        contactPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Contacts",
                TitledBorder.LEFT, TitledBorder.TOP));
        contactPanel.setBounds(20, 60, 440, 400);
        contactPanel.setLayout(new BorderLayout());
        mainFrame.add(contactPanel);

        tableModel = new DefaultTableModel(new String[] { "NAME", "NUMBER" }, 0);
        contactTable = new JTable(tableModel);
        contactPanel.add(new JScrollPane(contactTable), BorderLayout.CENTER);

        // Refresh the table to display initial data
        refreshContactTable();
    }

    // Method to refresh contact table
    public static void refreshContactTable() {
        UpdateContacts updateContacts = new UpdateContacts();
        updateContacts.printContacts();
    }

    // Build a button to open Add New Contacts screen
    public void addContact() {
        addNewCont = new JButton("Add new contact");
        addNewCont.setBounds(160, 470, 150, 30);
        addNewCont.addActionListener(e -> {
            AddNewContactScreen addContactScreen = new AddNewContactScreen();
            addContactScreen.showAddNewContactScreen();
        });
        mainFrame.add(addNewCont);
    }

    // Function to show ContactBookScreen
    public void showContactScreen() {
        contactHomeFrame();
        searchUi();
        contactTablePanel();
        addContact();
        mainFrame.setVisible(true);
    }
}
