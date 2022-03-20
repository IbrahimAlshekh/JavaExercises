package com.alshekh.JavaSwingExcercises;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Counter {

  public static JTextField input;

  public static void main(String[] args) {
    JFrame f=new JFrame();

    JLabel label = new JLabel("Counter:");
    label.setBounds(0,15, 70,30);
    f.add(label);

    input = new JTextField();
    input.setBounds(70, 15,100, 30);
    input.setText("0");
    f.add(input);

    JButton up = new JButton();
    up.setText("Count up");
    up.setBounds(180,15, 100,30);
    up.addActionListener(action("up"));
    f.add(up);

    JButton down = new JButton();
    down.setText("Count down");
    down.setBounds(300,15, 120,30);
    down.addActionListener(action("down"));
    f.add(down);

    JButton reset = new JButton();
    reset.setText("reset");
    reset.setBounds(440,15, 100,30);
    reset.addActionListener(action("reset"));
    f.add(reset);

    f.setSize(600,100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
  }

  public static ActionListener action(String type)
  {
    return e ->
    {
      int currentValue = Integer.parseInt(input.getText());

      switch (type){
        case "up" -> currentValue++;
        case "down" -> currentValue--;
        case "reset" -> currentValue = 0;
        default -> {}
      }

      input.setText(String.valueOf(currentValue));
    };
  }
}
