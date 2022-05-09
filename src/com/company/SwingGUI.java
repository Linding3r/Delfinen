package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SwingGUI extends JFrame{
  private JFrame frame;
  private JPanel panel;
  private ImageIcon dolphin;
  private JLabel myLabel;
  private JButton presidentButton;
  private JButton cashierButton;
  private JButton trainerButton;

  public void chooseUser(){

    dolphin = new ImageIcon(this.getClass().getResource("Delfinen/res/dolphin.jpg"));
    myLabel = new JLabel(dolphin);
    presidentButton = new JButton("President");
    presidentButton.setBounds(100,100,300,50);

    cashierButton = new JButton("Cashier");
    cashierButton.setBounds(100,200,300,50);

    trainerButton = new JButton("Trainer");
    trainerButton.setBounds(100,300,300,50);

    myLabel.add(presidentButton);
    myLabel.add(cashierButton);
    myLabel.add(trainerButton);
    frame.add(myLabel);
    frame.setSize(500, 500);
    Engine engine = new Engine();
    frame = new JFrame("Select Account");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(500, 100);
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());

   /* JLabel heading = new JLabel("Whose which account to login with: ");
    panel.add(heading);
    JButton presidentButton = (JButton) panel.add(new JButton("President"));
    JButton cashierButton = (JButton) panel.add(new JButton("Cashier"));
    JButton trainerButton = (JButton) panel.add(new JButton("Trainer"));
*/
    panel.add(presidentButton);
    panel.add(cashierButton);
    panel.add(trainerButton);

    presidentButton.addActionListener(e -> engine.presidentExecute(frame));
    cashierButton.addActionListener(e -> engine.cashierExecute(frame));
    trainerButton.addActionListener(e -> engine.trainerExecute(frame));

    frame.setVisible(true);
  }

  public void mainPanelPresident(){
    setTitle("Swimming Club Dolphin");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    //setting the bounds for the JFrame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    setBounds(100,100,screenSize.width, screenSize.height);
    setBounds(100,100,1200, 800);

    Border br = BorderFactory.createLineBorder(Color.black);
    Container c=getContentPane();

    JButton topPanel = new JButton("Option 1");
    JButton mid1Panel = new JButton("Option 2");
    JButton mid2Panel = new JButton("Option 3");
    JButton buttomPanel = new JButton("Option 4");
    JPanel textPanel = new JPanel();
    JTextField textField = new JTextField(100);
    JPanel inputField = new JPanel();

    topPanel.setLayout(null);
    mid1Panel.setLayout(null);
    mid2Panel.setLayout(null);
    buttomPanel.setLayout(null);
    textPanel.setLayout(null);
    textField.setLayout(null);
    inputField.setLayout(null);


    JLabel label5 = new JLabel("Input: ");


    label5.setBounds(0,0,50,20);
    ;
    inputField.add(label5);

    topPanel.setBounds(10,10,200,100);
    //Panel 1

    mid1Panel.setBounds(10,120,200,100);
    //Panel 2

    mid2Panel.setBounds(10,230,200,100);
    //Panel 3
    buttomPanel.setBounds(10,340,200,100);

    //text panel
    textPanel.setBounds(220,10,400,400);
    textPanel.setBackground(Color.white);
    //text field
    textField.setBounds(260,415,360,20);

    inputField.setBounds(220,414,50,20);

    topPanel.setVisible(true);
    topPanel.setBorder(br);
    mid1Panel.setBorder(br);
    mid2Panel.setBorder(br);
    buttomPanel.setBorder(br);
    textPanel.setBorder(br);
    textField.setBorder(br);


    c.add(topPanel);
    c.add(mid1Panel);
    c.add(mid2Panel);
    c.add(buttomPanel);
    c.add(textPanel);
    c.add(textField);
    c.add(inputField);

    setVisible(true);
    setLocationRelativeTo(null);

      String text = textField.getText();
      textField.setText(text);


  }

  private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
    }
  }

}
