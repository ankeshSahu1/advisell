/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.mz.irt.bo.profile.ProfileBo;
import org.mz.irt.bo.profile.ProfileBoImp1;
import org.mz.irt.bo.search.SearchBo;
import org.mz.irt.bo.search.SearchBoImp1;
import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public class SearchPanel extends javax.swing.JPanel {

    private final JFrame frame;

    /**
     * Creates new form GetAadharPanel
     */
    public SearchPanel(JFrame frame) {
        this.frame = frame;
        initComponents();
        searchOnChange();
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchOnChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchLbl = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        investmentResultLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientListPanel = new javax.swing.JPanel();

        searchLbl.setText("Enter aadhar card number/Phone number/Name");

        clientListPanel.setLayout(new javax.swing.BoxLayout(clientListPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(clientListPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(investmentResultLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(investmentResultLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void searchOnChange() {
        SearchBo searchBo = new SearchBoImp1();
        ArrayList<Profile> clientList = searchBo.getClientList(searchTextField.getText());
        clientListPanel.removeAll();
        if (!(clientList.isEmpty())) {
            for (Profile clientDetails : clientList) {
                JPanel clientPanel = new JPanel();
                clientPanel.setEnabled(true);
                clientPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                clientPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                JLabel clientNameLbl = new JLabel();
                JLabel clientPhoneNumberLbl = new JLabel();
                JLabel clientEmailIdLbl = new JLabel();
                JLabel clientAadharLbl = new JLabel();
                JButton editBtn = new JButton("Edit");
                JButton deleteBtn = new JButton("Delete");
                JButton investmentBtn = new JButton("Investment");
                clientNameLbl.setText(clientDetails.getFirstName() + " " + clientDetails.getLastName());
                clientPhoneNumberLbl.setText(clientDetails.getContactNumber());
                clientEmailIdLbl.setText(clientDetails.getEmailId());
                clientAadharLbl.setText(clientDetails.getAadharCardNumber());
                GroupLayout clientPanelLayout = new GroupLayout(clientPanel);
                clientPanel.setLayout(clientPanelLayout);
                clientPanelLayout.setHorizontalGroup(
                        clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(clientNameLbl, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clientPhoneNumberLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clientEmailIdLbl, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clientAadharLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(investmentBtn)
                                        .addContainerGap(180, Short.MAX_VALUE))
                );
                clientPanelLayout.setVerticalGroup(
                        clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(clientNameLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(investmentBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clientAadharLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clientEmailIdLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clientPhoneNumberLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(62, Short.MAX_VALUE))
                );

                investmentBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        investment(clientDetails);
                    }
                });

                deleteBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteProfile(clientDetails);
                    }
                });

                editBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        editProfile(clientDetails);
                    }
                });

                clientPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        viewProfile(clientDetails);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        clientPanel.setBackground(new Color(0, 204, 204));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        clientPanel.setBackground(new Color(240, 240, 240));
                    }
                });
                clientListPanel.add(clientPanel);
            }
            revalidate();
        }
    }

    private void editProfile(Profile client) {
        JDialog dialog = new JDialog(frame, true);
        dialog.add(new EditProfilePanel(frame, client));
        dialog.setSize(515, 515);
        dialog.setVisible(true);
        searchOnChange();
    }

    private void viewProfile(Profile client) {
        JDialog dialog = new JDialog(frame, true);
        dialog.add(new ClientProfilePanel(client));
        dialog.setSize(490, 515);
        dialog.setVisible(true);
    }

    private void deleteProfile(Profile client) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure want to delete this profile", "Confirmation Dialog", dialogButton);
        if (dialogResult == JOptionPane.OK_OPTION) {
            ProfileBo profileBo = new ProfileBoImp1();
            int result = profileBo.deleteProfile(client.getAadharCardNumber());
            if (result > 0) {
                investmentResultLbl.setText("Delete successfully");
                searchOnChange();
            } else {
                investmentResultLbl.setText("Error");
            }
        }
    }

    private void investment(Profile client) {
        JDialog dialog = new JDialog(frame, true);
        dialog.add(new InvestmentPanel(frame, client.getAadharCardNumber()));
        dialog.setSize(450, 400);
        dialog.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clientListPanel;
    private javax.swing.JLabel investmentResultLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
