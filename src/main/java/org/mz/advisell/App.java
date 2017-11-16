package org.mz.advisell;

import javax.swing.UIManager;
import org.mz.advisell.gui.AdvisellGUI;

/**
 * Hello world!
 *
 */
public class App 
{
     public static void main(String args[]) {
     try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(AdvisellGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); 
     }
     /* Create and display the form */
     java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new AdvisellGUI().setVisible(true);
        }
      });
    }
}
