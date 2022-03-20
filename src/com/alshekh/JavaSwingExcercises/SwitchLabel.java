package com.alshekh.JavaSwingExcercises;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SwitchLabel
{
  static JLabel leftLabel;
  static JLabel rightLabel;
  public static void main(String[] args)
  {
    JFrame f = new JFrame();

    JButton switcher = new JButton();
    switcher.setBounds(140, 15, 120, 30);
    switcher.setText("<- switch ->");
    switcher.addActionListener(action(250, 50));
    f.add(switcher);

    leftLabel = new JLabel();
    leftLabel.setBounds(10, 15, 100, 30);
    leftLabel.setText("LEFT");
    f.add(leftLabel);

    rightLabel = new JLabel();
    rightLabel.setBounds(350, 15, 100, 30);
    rightLabel.setText("RIGHT");
    f.add(rightLabel);

    f.setSize(400, 100);
    f.setTitle("Swing test");
    f.setLayout(null);
    f.setVisible(true);
  }

  public static ActionListener action(int x, int y){
    return e -> {
      String temp = leftLabel.getText();
      leftLabel.setText(rightLabel.getText());
      rightLabel.setText(temp);
    };
  }
}
