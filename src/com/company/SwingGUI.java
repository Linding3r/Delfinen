package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class SwingGUI {

    private JFrame frame;
    private TextArea textPanel;
    private JTextField textField;
    private final static String newline = "\n";
    private int memberID = 2022001;

    MemberList memberList = new MemberList();

    public void chooseUser() {
        frame = new JFrame();
        Engine engine = new Engine();
        frame.setTitle("President Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Container c = frame.getContentPane();
        frame.setBounds(0, 0, 300, 250);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Choose which account you wish to login to:");
        JButton presidentButton = new JButton("President");
        JButton cashierButton = new JButton("Cashier");
        JButton trainerButton = new JButton("Trainer");
        c.add(label);
        c.add(presidentButton);
        c.add(cashierButton);
        c.add(trainerButton);
        frame.setResizable(false);
        presidentButton.setBounds(75, 25, 150, 50);
        cashierButton.setBounds(75, 80, 150, 50);
        trainerButton.setBounds(75, 135, 150, 50);
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
        frame.setTitle("Swimming Club Dolphin");
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

        JButton createMember = new JButton("Create Member");
        JButton showMembers = new JButton("Show Members");
        JButton midButton2 = new JButton("Option 3");
        JButton buttomButton = new JButton("Save & Exit");

        textPanel = new TextArea();
        textField = new JTextField(100);
        JPanel inputField = new JPanel();

        JLabel label5 = new JLabel("Input: ");
        label5.setBounds(0, 0, 50, 20);
        inputField.add(label5);

        // Gives all panels a specific location on the screen.
        createMember.setBounds(10, 10, 200, 100);
        showMembers.setBounds(10, 120, 200, 100);
        midButton2.setBounds(10, 230, 200, 100);
        buttomButton.setBounds(10, 340, 200, 100);
        textPanel.setBounds(220, 10, 900, 400);
        textPanel.setBackground(Color.white);
        textField.setBounds(260, 415, 860, 20);

        //input field where user input is shown.
        inputField.setBounds(220, 414, 50, 20);

        //Makes the textfield uneditable
        textPanel.setEditable(false);

        // Adds border around all boxes.
        createMember.setBorder(br);
        showMembers.setBorder(br);
        midButton2.setBorder(br);
        buttomButton.setBorder(br);
        textField.setBorder(br);

        // Adds all Jframe components to the container which makes sure everything is visible.
        c.add(createMember);
        c.add(showMembers);
        c.add(midButton2);
        c.add(buttomButton);
        c.add(textPanel);
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

        createMember.addActionListener(e -> {
            frame.toBack();
            createUser(frame);
        });
        showMembers.addActionListener(e ->
        {
            for (int i = 0; i < memberList.getMemberList().size(); i++) {
                Member member = (memberList.getMemberList().get(i));
                String yesNoActive;
                String yesNoComp;

                if (member.isCompetitionSwimmer()){
                    yesNoComp = "Yes";
                }
                else yesNoComp = "No";
                if (member.isActive()){
                    yesNoActive = "Yes";
                }
                else yesNoActive = "No";
                textPanel.append("Name: " + member.getName() + newline +"Member ID: " + member.getId() + newline +
                        "Age: " + member.getAge() + newline + "Active membership: " + yesNoActive + newline +
                        "Competitive Member: " + yesNoComp + newline + newline);

            }

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

        JLabel name = new JLabel("Name: ");
        JLabel age = new JLabel("Age: ");
        JLabel activeMember = new JLabel("Active member: ");
        JLabel competitiveSwimmer = new JLabel("Competitive swimmer: ");

        JTextField textFieldName = new JTextField();
        JTextField textFieldAge = new JTextField();
        JCheckBox checkBoxActive = new JCheckBox();
        JCheckBox checkBoxComp = new JCheckBox();

        // Below keyListener will only accept numbers to avoid any exceptions.
        textFieldAge.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });

        JButton validateButton = new JButton("Validate & save");


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

    public void validateInput(JTextField textFieldName, JTextField textFieldAge, JCheckBox checkBoxActive, JCheckBox checkBoxComp, JFrame frameMember, JFrame frameMain) {
        Engine engine = new Engine();
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
            textPanel.append("User Created:" + newline + member + newline);
//            textPanel.append("Name: " + name + newline + "Age: " + age + newline + "Active member: " + active + newline + "Competitive swimmer: " + comp);
            memberList.addMemberToList(member);
            success(frameMember, frameMain);
            memberID++;
        } else error();


    }

    public void error() {
        frame = new JFrame("Oopps you messed up!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(320, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        JLabel label3 = new JLabel("Invalid input, try again");
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
        frame = new JFrame("SUCCESS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(320, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        JLabel label3 = new JLabel("User successfully created!");
        JPanel panel3 = new JPanel();
        frame.add(panel3);
        panel3.add(label3);
        JButton button2 = new JButton("Ok");
        panel3.add(button2);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        button2.addActionListener(f -> {frame.dispose(); frameMember.dispose(); frameMain.toFront();});
    }

/*  public void mainPanelCashier() {
    setTitle("Swimming Club Dolphin");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    //setting the bounds for the JFrame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    setBounds(100, 100, 1200, 800);
    setBounds(100,100,screenSize.width, screenSize.height);

    // Used to create a border around all objects.
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = getContentPane();

    // Creating the buttons, textfields and textarea.

    JButton topButton = new JButton("Option 1");
    JButton midButton = new JButton("Option 2");
    JButton midButton2 = new JButton("Option 3");
    JButton buttomButton = new JButton("Option 4");
    textPanel = new TextArea();
    textField = new JTextField(100);
    JPanel inputField = new JPanel();

    topButton.setLayout(null);
    midButton.setLayout(null);
    midButton2.setLayout(null);
    buttomButton.setLayout(null);
    textField.setLayout(null);
    inputField.setLayout(null);

    JLabel label5 = new JLabel("Input: ");
    label5.setBounds(0, 0, 50, 20);
    inputField.add(label5);

    //

    // Gives all panels a specific location on the screen.
    topButton.setBounds(10, 10, 200, 100);
    midButton.setBounds(10, 120, 200, 100);
    midButton2.setBounds(10, 230, 200, 100);
    buttomButton.setBounds(10, 340, 200, 100);
    textPanel.setBounds(220, 10, 700, 400);
    textPanel.setBackground(Color.white);
    textField.setBounds(260, 415, 660, 20);

    //input field where user input is shown.
    inputField.setBounds(220, 414, 50, 20);

    // Adds border around all boxes.
    topButton.setBorder(br);
    midButton.setBorder(br);
    midButton2.setBorder(br);
    buttomButton.setBorder(br);
    textField.setBorder(br);


    // welcome text
    textPanel.append("Welcome to the Cashier menu!!" + newline);

    // Adds all Jframe components to the container which makes sure everything is visible.
    c.add(topButton);
    c.add(midButton);
    c.add(midButton2);
    c.add(buttomButton);
    c.add(textPanel);
    c.add(textField);
    c.add(inputField);

    setResizable(false);
    // sets visibility. This is required to open the window in the first place. If visibility == false, it will not
    // open at all.
    setVisible(true);

    // Sets the position to the middle of the screen.
    setLocationRelativeTo(null);

    // When pressing enter it will perform below action.
    textField.addActionListener(action);



  }

  public void mainPanelTrainer() {
    setTitle("Swimming Club Dolphin");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    //setting the bounds for the JFrame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    setBounds(100, 100, 1200, 800);
    setBounds(100,100,screenSize.width, screenSize.height);

    // Used to create a border around all objects.
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = getContentPane();

    // Creating the buttons, textfields and textarea.

    JButton topButton = new JButton("Option 1");
    JButton midButton = new JButton("Option 2");
    JButton midButton2 = new JButton("Option 3");
    JButton buttomButton = new JButton("Option 4");
    textPanel = new TextArea();
    textField = new JTextField(100);
    JPanel inputField = new JPanel();

    topButton.setLayout(null);
    midButton.setLayout(null);
    midButton2.setLayout(null);
    buttomButton.setLayout(null);
    textField.setLayout(null);
    inputField.setLayout(null);

    JLabel label5 = new JLabel("Input: ");
    label5.setBounds(0, 0, 50, 20);
    inputField.add(label5);

    //

    // Gives all panels a specific location on the screen.
    topButton.setBounds(10, 10, 200, 100);
    midButton.setBounds(10, 120, 200, 100);
    midButton2.setBounds(10, 230, 200, 100);
    buttomButton.setBounds(10, 340, 200, 100);
    textPanel.setBounds(220, 10, 700, 400);
    textPanel.setBackground(Color.white);
    textField.setBounds(260, 415, 660, 20);

    //input field where user input is shown.
    inputField.setBounds(220, 414, 50, 20);

    // Adds border around all boxes.
    topButton.setBorder(br);
    midButton.setBorder(br);
    midButton2.setBorder(br);
    buttomButton.setBorder(br);
    textField.setBorder(br);

    setResizable(false);
    // welcome text
    textPanel.append("Welcome to the Trainer menu!!" + newline);

    // Adds all Jframe components to the container which makes sure everything is visible.
    c.add(topButton);
    c.add(midButton);
    c.add(midButton2);
    c.add(buttomButton);
    c.add(textPanel);
    c.add(textField);
    c.add(inputField);

    // sets visibility. This is required to open the window in the first place. If visibility == false, it will not
    // open at all.
    setVisible(true);

    // Sets the position to the middle of the screen.
    setLocationRelativeTo(null);

    // When pressing enter it will perform below action.
    textField.addActionListener(action);

  }*/

    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Adds string from the text field and adds it to the textpanel. It will then make a new line and remove input
            // from the text field.

            String text = textField.getText();
            if (Objects.equals(textField.getText(), "clear")){
                textPanel.setText("");
                textField.setText("");
            }
            else
            textPanel.append(text + newline);
            textField.setText("");
        }
    };

}
