package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int memberID = 2022001;

    MemberList memberList = new MemberList();

    public void chooseUser() {
        frame = new JFrame();
        Engine engine = new Engine();
        frame.setTitle("Vælg bruger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Container c = frame.getContentPane();
        frame.setBounds(0, 0, 320, 250);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Vælg hvilken bruger du ønsker at logge ind på:");
        JButton presidentButton = new JButton("Formand");
        JButton cashierButton = new JButton("Kaserer");
        JButton trainerButton = new JButton("Træner");
        c.add(label);
        c.add(presidentButton);
        c.add(cashierButton);
        c.add(trainerButton);
        frame.setResizable(false);
        presidentButton.setBounds(95, 25, 150, 50);
        cashierButton.setBounds(95, 80, 150, 50);
        trainerButton.setBounds(95, 135, 150, 50);
        label.setBounds(10, 0, 300, 20);


        presidentButton.addActionListener(e -> {
            engine.presidentExecute();
            frame.setVisible(false);
        });
        cashierButton.addActionListener(e -> {
            engine.cashierExecute();
            frame.setVisible(false);
        });
        trainerButton.addActionListener(e -> {
            engine.trainerExecute();
            frame.setVisible(false);
        });


        frame.setVisible(true);
    }

    public void mainPanelPresident() {
        frame = new JFrame();
        frame.setTitle("Svømmeklubben Delfinen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //setting the bounds for the JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(100, 100, 1200, 800);
//    setBounds(100,100,screenSize.width, screenSize.height);

        // Used to create a border around all objects.
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = frame.getContentPane();

        // Creating the buttons, textfields and textarea.

        JButton createMember = new JButton("Opret nyt medlem");
        JButton showMembers = new JButton("Vis medlemmer i tabel");
        JButton deleteMember = new JButton("Slet medlem");
        JButton buttomButton = new JButton("Gem og luk");

        textArea = new JTextArea();
        textField = new JTextField(100);
        JPanel inputField = new JPanel();

        JLabel label5 = new JLabel("Input: ");
        label5.setBounds(0, 0, 50, 20);
        inputField.add(label5);

        // Gives all panels a specific location on the screen.
        createMember.setBounds(10, 10, 200, 100);
        showMembers.setBounds(10, 120, 200, 100);
        deleteMember.setBounds(10, 230, 200, 100);
        buttomButton.setBounds(10, 340, 200, 100);
        textArea.setBounds(220, 10, 900, 400);
        textArea.setBackground(Color.white);
        textField.setBounds(260, 415, 860, 20);

        //input field where user input is shown.
        inputField.setBounds(220, 414, 50, 20);

        //Makes the textfield uneditable
        textArea.setEditable(false);

        // Adds border around all boxes.
        createMember.setBorder(br);
        showMembers.setBorder(br);
        deleteMember.setBorder(br);
        buttomButton.setBorder(br);
        textField.setBorder(br);

        // Adds all Jframe components to the container which makes sure everything is visible.
        c.add(createMember);
        c.add(showMembers);
        c.add(deleteMember);
        c.add(buttomButton);
        c.add(textArea);
        c.add(textField);
        c.add(inputField);

        // sets visibility. This is required to open the window in the first place. If visibility == false, it will not
        // open at all.
        frame.setVisible(true);
        frame.setResizable(false);
        // Sets the position to the middle of the screen.
        frame.setLocationRelativeTo(null);
        // When pressing enter it will perform below action.
        textField.addActionListener(action);

        deleteMember.addActionListener(e -> {
            deleteMember();
        });

        createMember.addActionListener(e -> {
            frame.toBack();
            createUser(frame);
        });
        showMembers.addActionListener(e ->
        {
            membersTable();
        });

        buttomButton.addActionListener(e -> System.exit(frame.EXIT_ON_CLOSE));

    }

    private void createUser(JFrame frameMain) {
        frame = new JFrame();
        frame.setTitle("Create Member");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(0, 0, 500, 230);

        Container c = frame.getContentPane();

        JLabel name = new JLabel("Fornavn: ");
        JLabel age = new JLabel("Alder: ");
        JLabel activeMember = new JLabel("Aktivt medlem: ");
        JLabel competitiveSwimmer = new JLabel("Konkurrence svømmer: ");

        JTextField textFieldName = new JTextField();
        JTextField textFieldAge = new JTextField();
        JCheckBox checkBoxActive = new JCheckBox();
        JCheckBox checkBoxComp = new JCheckBox();

        // Below keyListener will only accept numbers to avoid any exceptions.
        textFieldAge.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
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
            if (Objects.equals(textField.getText(), "clear")) {
                textArea.setText("");
                textField.setText("");
            } else
                textArea.append(text + newline);
            textField.setText("");
        }
    };

    public void validateInput(JTextField textFieldName, JTextField textFieldAge, JCheckBox checkBoxActive, JCheckBox checkBoxComp, JFrame frameMember, JFrame frameMain) {
        String name;
        int age;
        if (Objects.equals(textFieldAge.getText(), "")) {
            age = 0;
            textFieldAge.setText("0");
        } else age = Integer.parseInt(textFieldAge.getText());
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
        if (age > 100 || age <= 0) {
            textFieldAge.setBorder(br);
        } else br = BorderFactory.createLineBorder(Color.WHITE);
        textFieldAge.setBorder(br);


        if (!Objects.equals(textFieldName.getText(), "") && (!(age > 100) && (!(age < 0)))) {
            Member member = new Member(age, memberID, name, active, comp);
            textArea.append("User Created:" + newline + member + newline);
//            textPanel.append("Name: " + name + newline + "Age: " + age + newline + "Active member: " + active + newline + "Competitive swimmer: " + comp);
            memberList.addMemberToList(member);
            success(frameMember, frameMain);
            memberID++;
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

    public void deleteMember(){
        frame = new JFrame("Slet Bruger");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(320, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("Hvilken bruger ønsker du at slette?");
        JLabel label2 = new JLabel("Skriv medlemsnummer");

        frame.add(panel);
        panel.setBounds(0,0,100,100);
        panel2.setBounds(100,100,200,200);
        panel.add(label);
        panel.add(label2);
        frame.add(panel2);
        JTextField userID = new JTextField();
        panel2.add(userID);
        userID.setBounds(150,100,150,20);
        userID.addActionListener(action);
        frame.setVisible(true);
    }

    public void membersTable() {

        JFrame f = new JFrame();
        JTable j;

        // Frame Title
        f.setTitle("Tabel over medlemmer");
        String[][] data = new String[memberList.getMemberList().size()][5];
        String[] columnNames = {"Navn", "Alder", "Medlemsnummer", "Aktivt medlem", "Konkurrencesvømmer"};
        for (int i = 0; i < memberList.getMemberList().size(); i++) {
            Member member = memberList.getMemberList().get(i);
            data[i][0] = member.getName();
            data[i][1] = String.valueOf(member.getAge());
            data[i][2] = String.valueOf(member.getId());
            data[i][3] = String.valueOf(member.isActive());
            data[i][4] = String.valueOf(member.isCompetitionSwimmer());
            // Initializing the JTable
        }
        j = new JTable(data, columnNames);
        j.setAutoCreateRowSorter(true);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames){

            @Override
            public boolean isCellEditable(int row, int column)
            {
                // make read only fields except column 0,13,14
                return column == 0 || column == 3 || column == 1 || column == 4;
            }
        };
        j.setModel(tableModel);
        // Column Names
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(700, 200);
        // Frame Visible = true
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

}
