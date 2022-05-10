package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwingGUI extends JFrame{

  private TextArea textPanel;
  private JTextField textField;
  private final static String newline = "\n";

  public void chooseUser(){
    Engine engine = new Engine();
    setTitle("President Account");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    Container c = getContentPane();
    setBounds(0, 0, 300, 250);
    setLocationRelativeTo(null);

    JLabel label = new JLabel("Choose which account you wish to login to:");
    JButton presidentButton = new JButton("President");
    JButton cashierButton = new JButton("Cashier");
    JButton trainerButton = new JButton("Trainer");
    c.add(label);
    c.add(presidentButton);
    c.add(cashierButton);
    c.add(trainerButton);
    setResizable(false);
    presidentButton.setBounds(75,50,150,50);
    cashierButton.setBounds(75,100,150,50);
    trainerButton.setBounds(75,150,150,50);
    label.setBounds(10,0,300,20);

    presidentButton.addActionListener(e -> {engine.presidentExecute(); setVisible(false);});
    cashierButton.addActionListener(e -> {engine.cashierExecute(); setVisible(false);});
    trainerButton.addActionListener(e -> {engine.trainerExecute(); setVisible(false);});


    setVisible(true);
  }

  public void mainPanelPresident() {
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
    JButton buttomButton = new JButton("Save & Exit");
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
    textPanel.append("Welcome to the President menu!!" + newline);

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
    setResizable(false);
    // Sets the position to the middle of the screen.
    setLocationRelativeTo(null);
    // When pressing enter it will perform below action.
    textField.addActionListener(action);

  }

  public void mainPanelCashier() {
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

  }

  Action action = new AbstractAction()
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      // Adds string from the text field and adds it to the textpanel. It will then make a new line and remove input
      // from the text field.

      String text = textField.getText();
      textPanel.append(text + newline);
      textField.setText("");
    }
  };

}
