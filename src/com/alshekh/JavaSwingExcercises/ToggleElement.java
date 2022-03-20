package com.alshekh.JavaSwingExcercises;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ToggleElement {

  public static JLabel label;
  public static JButton button;
  public static boolean showLabel;

  public static void main(String[] args) {
    JFrame f=new JFrame();
    showLabel = true;

    label = new JLabel("The Text to be toggle");
    label.setBounds(50,50, 300,30);
    label.setVisible(showLabel);
    f.add(label);

    button = new JButton();
    button.setText("Hide the text");
    button.setBounds(50,20, 300,30);
    button.addActionListener(e ->
    {
      showLabel = !showLabel;

      String buttonText = (showLabel) ? "Hide the text" : "Show the text";
      button.setText(buttonText);
      label.setVisible(showLabel);
    });
    f.add(button);

    f.setSize(400,150);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
  }
}