package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwingGUI extends JFrame{
  private JFrame frame;
  private JPanel panel;

  private JButton presidentButton;
  private JButton cashierButton;
  private JButton trainerButton;
  private TextArea textPanel;
  private JTextField textField;
  private final static String newline = "\n";

  public void chooseUser(){

    Engine engine = new Engine();
    frame = new JFrame("Select Account");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(500, 300);
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());

    JButton presidentButton = new JButton("President");

    JButton cashierButton = new JButton("Cashier");
    cashierButton.setBounds(100,200,300,50);

    JButton trainerButton = new JButton("Trainer");
    trainerButton.setBounds(100,300,300,50);
    JLabel heading = new JLabel("Whose which account to login with: ");
    panel.add(heading);
    panel.add(presidentButton);

    JPanel panel2 = new JPanel();
    panel.setBounds(50,100,300,300);

/*    JButton presidentButton = new JButton("President");
    JButton cashierButton = (JButton) panel.add(new JButton("Cashier"));
    JButton trainerButton = (JButton) panel.add(new JButton("Trainer"));*/


    presidentButton.addActionListener(e -> engine.presidentExecute(frame));
    cashierButton.addActionListener(e -> engine.cashierExecute(frame));
    trainerButton.addActionListener(e -> engine.trainerExecute(frame));

    frame.setVisible(true);
  }

  public void mainPanelPresident() {
    setTitle("Swimming Club Dolphin");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    //setting the bounds for the JFrame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(100, 100, 1200, 800);
//    setBounds(100,100,screenSize.width, screenSize.height);

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
    setBounds(100, 100, 1200, 800);
//    setBounds(100,100,screenSize.width, screenSize.height);

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
    setBounds(100, 100, 1200, 800);
//    setBounds(100,100,screenSize.width, screenSize.height);

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
