package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Year;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingGUI {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private final static String newline = "\n";
    private int memberID = Integer.parseInt(String.valueOf(Year.now())) * 1000 + 1;

    MemberList memberList = new MemberList();

    public void mainMenu() {
        frame = new JFrame();
        frame.setTitle("Svømmeklubben Delfinen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //setting the bounds for the JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(100, 100, 1200, 810);
//    setBounds(100,100,screenSize.width, screenSize.height);

        // Used to create a border around all objects.
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = frame.getContentPane();

        // Creating the buttons, textfields and textarea.

        JButton createMember = new JButton("Opret nyt medlem");
        JButton showMembers = new JButton("Vis medlemmer i tabel");
        JButton deleteMember = new JButton("Slet medlem");
        JButton button1 = new JButton("Knap");
        JButton button2 = new JButton("Knap");
        JButton button3 = new JButton("Knap");
        JButton saveAndExit = new JButton("Gem og luk");
        JButton clearScreen = new JButton("Ryd skærmen");

        textArea = new JTextArea();
        textField = new JTextField(100);
        JPanel inputField = new JPanel();

        JLabel label5 = new JLabel("Input: ");
        label5.setBounds(0, 0, 50, 20);
        inputField.add(label5);

        // Gives all panels a specific location on the screen.
        createMember.setBounds(10, 10, 200, 100);
        showMembers.setBounds(10, 120, 200, 100);
        button1.setBounds(10, 230, 200, 100);
        button2.setBounds(10, 340, 200, 100);
        button3.setBounds(10, 450, 200, 100);
        deleteMember.setBounds(10, 560, 200, 100);


        saveAndExit.setBounds(10, 670, 200, 100);
        clearScreen.setBounds(260, 740, 100, 20);

        textArea.setBounds(220, 10, 900, 700);
        textArea.setBackground(Color.white);
        textField.setBounds(260, 715, 860, 20);

        //input field where user input is shown.
        inputField.setBounds(215, 710, 50, 20);

        //Makes the textfield uneditable
        textArea.setEditable(false);

        // Adds border around all boxes.
        createMember.setBorder(br);
        showMembers.setBorder(br);
        deleteMember.setBorder(br);
        saveAndExit.setBorder(br);
        textField.setBorder(br);
        clearScreen.setBorder(br);
        button1.setBorder(br);
        button2.setBorder(br);
        button3.setBorder(br);

        // Adds all Jframe components to the container which makes sure everything is visible.
        c.add(createMember);
        c.add(showMembers);
        c.add(deleteMember);
        c.add(saveAndExit);
        c.add(textArea);
        c.add(textField);
        c.add(inputField);
        c.add(clearScreen);
        c.add(button1);
        c.add(button2);
        c.add(button3);

        // sets visibility. This is required to open the window in the first place. If visibility == false, it will not
        // open at all.
        frame.setVisible(true);
        frame.setResizable(false);
        // Sets the position to the middle of the screen.
        frame.setLocationRelativeTo(null);
        // When pressing enter it will perform below action.
        textField.addActionListener(action);

        clearScreen.addActionListener(e -> {
            textArea.setText("");
            textField.setText("");
        });
        deleteMember.addActionListener(e -> {
            deleteMember(textField, textArea);
        });

        createMember.addActionListener(e -> {
            frame.toBack();
            createUser(frame);
        });
        showMembers.addActionListener(e ->
        {
            membersTable();
        });

        saveAndExit.addActionListener(e -> System.exit(frame.EXIT_ON_CLOSE));

    }

    private void createUser(JFrame frameMain) {
        frame = new JFrame();
        frame.setTitle("Create Member");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(0, 0, 500, 230);

        Container c = frame.getContentPane();

        JLabel name = new JLabel("Fornavn: ");
        JLabel age = new JLabel("Fødselsdagsdato: (DD/MM/YYYY) ");
        JLabel activeMember = new JLabel("Aktivt medlem: ");
        JLabel competitiveSwimmer = new JLabel("Konkurrence svømmer: ");

        JTextField textFieldName = new JTextField();
        JTextField textFieldAge = new JTextField();
        JCheckBox checkBoxActive = new JCheckBox();
        JCheckBox checkBoxComp = new JCheckBox();

        checkBoxActive.setSelected(true);

        // Below keyListener will only accept numbers to avoid any exceptions.
        textFieldAge.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && c != KeyEvent.VK_SLASH && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });

        JButton validateButton = new JButton("Valider og gem");


        c.add(name);
        c.add(textFieldName);
        c.add(age);
        c.add(textFieldAge);
        c.add(activeMember);
        c.add(checkBoxActive);
        c.add(competitiveSwimmer);
        c.add(checkBoxComp);

        c.add(validateButton);

        name.setBounds(5, 5, 200, 20);
        textFieldName.setBounds(205, 5, 200, 20);
        age.setBounds(5, 30, 200, 20);
        textFieldAge.setBounds(205, 30, 200, 20);
        activeMember.setBounds(5, 60, 200, 20);
        checkBoxActive.setBounds(200, 60, 200, 20);
        competitiveSwimmer.setBounds(5, 90, 200, 20);
        checkBoxComp.setBounds(200, 90, 200, 20);


        validateButton.setBounds(150, 120, 150, 50);


        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.toFront();

        validateButton.addActionListener(e -> validateInput(textFieldName, textFieldAge, checkBoxActive, checkBoxComp, frame, frameMain));

    }

    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Adds string from the text field and adds it to the textpanel. It will then make a new line and remove input
            // from the text field.

            String text = textField.getText();
            if (Objects.equals(textField.getText(), "ryd")) {

                textArea.setText("");
                textField.setText("");
            } else
            textField.setText("");
        }
    };

    public void validateInput(JTextField textFieldName, JTextField textFieldAge, JCheckBox checkBoxActive, JCheckBox checkBoxComp, JFrame frameMember, JFrame frameMain) {
        String name;
        String age;
        Birthday birthday = new Birthday();
        age =  birthday.checkBirthday(textFieldAge);
        boolean active;
        boolean comp;
        name = textFieldName.getText();


        active = checkBoxActive.isSelected();
        comp = checkBoxComp.isSelected();
        Border br;
        if (Objects.equals(textFieldName.getText(), "")) {
            br = BorderFactory.createLineBorder(Color.RED);
            textFieldName.setBorder(br);
        } else br = BorderFactory.createLineBorder(Color.WHITE);
        textFieldName.setBorder(br);


       /* if (age > 100 || age <= 0) {
            textFieldAge.setBorder(br);
        } else br = BorderFactory.createLineBorder(Color.WHITE);
        textFieldAge.setBorder(br);
*/
        if (!Objects.equals(textFieldName.getText(), "") && birthday.checkBirthday(textFieldAge) != null) {
            Member member = new Member(birthday, memberID, name, active, comp);
            if (memberList.getMemberList() != null && !(memberList.getMemberList().isEmpty())) {
                int calculateNewYear = memberList.getMemberList().get(memberList.getMemberList().size() - 1).getId() - Integer.parseInt(String.valueOf(Year.now()));
                memberID = Integer.parseInt(String.valueOf(Year.now())) + calculateNewYear + 1;
            }

            textArea.append("Medlem oprettet: " + newline + member + newline);
            memberList.addMemberToList(member);
            memberID++;
            if (memberID == 2023000) {
                memberID = 20221000;
            }
            success(frameMember, frameMain);

        } else error();


    }

    public void error() {
        frame = new JFrame("Fejl!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(320, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        JLabel label3 = new JLabel("Ugyldigt valg, prøv igen");
        JPanel panel3 = new JPanel();
        frame.add(panel3);
        panel3.add(label3);
        JButton button2 = new JButton("OK");
        panel3.add(button2);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        button2.addActionListener(f -> frame.dispose());
    }

    public void success(JFrame frameMember, JFrame frameMain) {
        frame = new JFrame("Success");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(320, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel label3 = new JLabel("Brugeren er blevet oprettet");
        JPanel panel3 = new JPanel();
        frame.add(panel3);
        panel3.add(label3);
        JButton button2 = new JButton("Ok");
        panel3.add(button2);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        button2.addActionListener(f -> {
            frame.dispose();
            frameMember.dispose();
            frameMain.toFront();
        });
    }

    public void deleteMember(JTextField textField, JTextArea textArea) {
        try {
            for (int i = 0; i < memberList.getMemberList().size(); i++) {
                int getID = memberList.getMemberList().get(i).getId();
                if (Objects.equals(textField.getText(), "")) {
                    textArea.append("Ugyldigt nummer. Indtast medlemsnummeret i input feltet under." + newline);
                } else if (Integer.parseInt(textField.getText()) == getID) {
                    textArea.append(newline + "Du har slettet: " + newline + memberList.getMemberList().get(i).getName() + ", Medlemsnummer: " + getID);
                    memberList.getMemberList().remove(i);
                    textField.setText("");
                }
            }
        } catch (NumberFormatException e) {
        }
    }

    public void membersTable() {

        JFrame f = new JFrame();
        JTable j;

        // Frame Title
        f.setTitle("Tabel over medlemmer");
        String[][] data = new String[memberList.getMemberList().size()][6];
        String[] columnNames = {"Navn:", "Fødselsdagsdato:", "Medlemstype:", "Medlemsnummer:", "Aktivt medlem:", "Konkurrencesvømmer:"};
        for (int i = 0; i < memberList.getMemberList().size(); i++) {
            Member member = memberList.getMemberList().get(i);
            data[i][0] = member.getName();
            data[i][1] = String.valueOf(((member.getBirthday().getBirthday())));
            data[i][2] = String.valueOf(member.getBirthday().membershipType());
            data[i][3] = String.valueOf(member.getId());
            String yesNoActive;
            String yesNoComp;
            if (member.isCompetitionSwimmer()) {
                yesNoComp = "Ja";
            } else yesNoComp = "Nej";
            if (member.isActive()) {
                yesNoActive = "Ja";
            } else yesNoActive = "Nej";
            data[i][4] = yesNoActive;
            data[i][5] = yesNoComp;
            // Initializing the JTable
        }
        j = new JTable(data, columnNames);
        j.setAutoCreateRowSorter(true);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                // make read only fields except column 0,13,14
                return column == 0 || column == 2 || column == 1 || column == 4;
            }
        };
        j.setModel(tableModel);
        // Column Names
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(1000, 200);
        // Frame Visible = true
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

}
