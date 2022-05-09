package com.company;

import javax.swing.*;
import java.awt.*;


public class SwingGUI {
  private JFrame frame;
  private JPanel panel;
  private JPanel panel2;
  private ImageIcon dolphin;
  private JLabel myLabel;
  private JButton presidentButton;
  private JButton cashierButton;
  private JButton trainerButton;



  public void chooseUser() {
    Engine engine = new Engine();
    dolphin = new ImageIcon(this.getClass().getResource("/dolphin.jpg"));
    myLabel = new JLabel(dolphin);
    myLabel.setSize(500,500);
    frame = new JFrame("Select Account");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());

    frame.add(panel2 = new JPanel());

    /*JLabel heading = new JLabel("Chose which account to login with: ");
    panel2.add(heading);
    JButton presidentButton = (JButton) panel.add(new JButton("President"));
    JButton cashierButton = (JButton) panel.add(new JButton("Cashier"));
    JButton trainerButton = (JButton) panel.add(new JButton("Trainer"));

    panel2.add(presidentButton);
    panel2.add(cashierButton);
    panel2.add(trainerButton);
    */
    presidentButton.addActionListener(e -> engine.presidentExecute(frame));
    cashierButton.addActionListener(e -> engine.cashierExecute(frame));
    trainerButton.addActionListener(e -> engine.trainerExecute(frame));
    frame.setVisible(true);
  }



}
