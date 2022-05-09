package com.company;

import javax.swing.*;

public class SwingGUI {
  private JFrame frame;
  private JPanel panel;
  private JPanel panel2;



  public void chooseUser(){
    Engine engine = new Engine();
    frame = new JFrame("Select Account");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(500, 100);
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());


    frame.add(panel2 = new JPanel());

    JLabel heading = new JLabel("Whose which account to login with: ");
    panel2.add(heading);
    JButton presidentButton = (JButton) panel.add(new JButton("President"));
    JButton cashierButton = (JButton) panel.add(new JButton("Cashier"));
    JButton trainerButton = (JButton) panel.add(new JButton("Trainer"));

    panel2.add(presidentButton);
    panel2.add(cashierButton);
    panel2.add(trainerButton);

    presidentButton.addActionListener(e -> engine.presidentExecute(frame));
    cashierButton.addActionListener(e -> engine.cashierExecute(frame));
    trainerButton.addActionListener(e -> engine.trainerExecute(frame));
    frame.setVisible(true);
  }



}
