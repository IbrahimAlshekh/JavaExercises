package com.alshekh.JavaSwingExcercises;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class PopUpFrame {

  PopUpFrame() {
    JFrame f = new JFrame();
    f.setSize(300, 300);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem past = new JMenuItem("Past");
    JMenuItem Pcut = new JMenuItem("Cut");
    JMenuItem Pcopy = new JMenuItem("Copy");
    JMenuItem Ppast = new JMenuItem("Past");
    menuBar.add(file);
    file.add(save);
    file.add(close);
    menuBar.add(edit);
    edit.add(cut);
    edit.add(copy);
    edit.add(past);
    JTextArea t = new JTextArea();

    JPopupMenu p = new JPopupMenu();
    p.add(Pcut);
    p.add(Pcopy);
    p.add(Ppast);


    t.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) )
          p.show(t, e.getX(), e.getY());

      }
    });

    t.add(p);
    f.add(p);
    f.add(t);


    f.setJMenuBar(menuBar);
    f.setVisible(true);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args){

    new PopUpFrame();

  }

}