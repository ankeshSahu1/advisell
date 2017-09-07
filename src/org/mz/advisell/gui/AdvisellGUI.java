/*
 * Copyright (C) 2017 Metazone Infotech Pvt Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mz.advisell.gui;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author metazone
 */
public class AdvisellGUI extends javax.swing.JFrame {

    /**
     * Creates new AdvisellGUI
     */
    public AdvisellGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        investOptionDialog = new javax.swing.JDialog();
        messageLbl = new javax.swing.JLabel();
        investBtn = new javax.swing.JButton();
        laterBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProfileMenuItem = new javax.swing.JMenuItem();
        searchMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        settingsMenuItem = new javax.swing.JMenuItem();

        investOptionDialog.setTitle("Invest Option");
        investOptionDialog.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        investOptionDialog.setIconImage(null);
        investOptionDialog.setPreferredSize(new java.awt.Dimension(292, 90));
        investOptionDialog.setResizable(false);
        investOptionDialog.setType(java.awt.Window.Type.POPUP);

        messageLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        messageLbl.setText("Record Investment?");

        investBtn.setText("Invest");
        investBtn.setPreferredSize(new java.awt.Dimension(65, 23));
        investBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                investBtnActionPerformed(evt);
            }
        });

        laterBtn.setText("Later");
        laterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout investOptionDialogLayout = new javax.swing.GroupLayout(investOptionDialog.getContentPane());
        investOptionDialog.getContentPane().setLayout(investOptionDialogLayout);
        investOptionDialogLayout.setHorizontalGroup(
            investOptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(investOptionDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(investOptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(investOptionDialogLayout.createSequentialGroup()
                        .addComponent(investBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(laterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(messageLbl))
                .addGap(20, 20, 20))
        );
        investOptionDialogLayout.setVerticalGroup(
            investOptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(investOptionDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(messageLbl)
                .addGap(18, 18, 18)
                .addGroup(investOptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laterBtn)
                    .addComponent(investBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Advisell");
        setIconImage(new ImageIcon(getClass().getResource("../images/logo_icon.png")).getImage());
        setResizable(false);

        contentPanel.setLayout(new java.awt.BorderLayout());

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/mz/advisell/images/logo_home.png"))); // NOI18N
        logoLabel.setToolTipText("");
        contentPanel.add(logoLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        newProfileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProfileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/mz/advisell/images/icon_new_profile.png"))); // NOI18N
        newProfileMenuItem.setText("New Profile");
        newProfileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProfileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newProfileMenuItem);

        searchMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        searchMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/mz/advisell/images/icon_search.png"))); // NOI18N
        searchMenuItem.setText("Search...");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(searchMenuItem);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/mz/advisell/images/turn-off.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        adminMenu.setText("Admin");

        settingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        settingsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/mz/advisell/images/icon_settings.png"))); // NOI18N
        settingsMenuItem.setText("Settings");
        settingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuItemActionPerformed(evt);
            }
        });
        adminMenu.add(settingsMenuItem);

        menuBar.add(adminMenu);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newProfileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProfileMenuItemActionPerformed
        new FillProfileDialog(this, true, null).setVisible(true);
    }//GEN-LAST:event_newProfileMenuItemActionPerformed

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
        this.add(new SearchPanel(this),0);
        this.revalidate();
    }//GEN-LAST:event_searchMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void settingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuItemActionPerformed
        this.add(new SchemesPanel(),0);
        this.revalidate();
    }//GEN-LAST:event_settingsMenuItemActionPerformed

    private void investBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_investBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_investBtnActionPerformed

    private void laterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laterBtnActionPerformed
        dispose();
    }//GEN-LAST:event_laterBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvisellGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdvisellGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminMenu;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton investBtn;
    private javax.swing.JDialog investOptionDialog;
    private javax.swing.JButton laterBtn;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel messageLbl;
    private javax.swing.JMenuItem newProfileMenuItem;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JMenuItem settingsMenuItem;
    // End of variables declaration//GEN-END:variables
}