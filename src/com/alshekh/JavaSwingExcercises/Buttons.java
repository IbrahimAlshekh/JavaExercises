package com.alshekh.JavaSwingExcercises;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Buttons
{
  static JButton box;
  public static void main(String[] args)
  {
    JFrame f = new JFrame();

    JButton up = new JButton();
    up.setBounds(250, 10, 100, 30);
    up.setText("Up");
    up.addActionListener(action(250, 50));
    f.add(up);

    JButton down = new JButton();
    down.setBounds(250, 220, 100, 30);
    down.setText("Down");
    down.addActionListener(action(250, 160));
    f.add(down);

    JButton right = new JButton();
    right.setBounds(10, 100, 100, 30);
    right.setText("Right");
    right.addActionListener(action(120, 90));
    f.add(right);

    JButton left = new JButton();
    left.setBounds(490, 100, 100, 30);
    left.setText("Left");
    left.addActionListener(action(380, 90));
    f.add(left);

    box = new JButton();
    box.setBounds(250, 90, 100, 50);
    box.addActionListener(action(250, 90));
    f.add(box);

    f.setSize(600, 300);
    f.setTitle("Swing test");
    f.setLayout(null);
    f.setVisible(true);
  }

  public static ActionListener action(int x, int y){
    return e -> box.setBounds(x,y,100, 50);
  }
}

