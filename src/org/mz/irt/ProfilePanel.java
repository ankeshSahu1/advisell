/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.mz.irt.model.Profile;
import org.mz.irt.bo.profile.ProfileBo;
import org.mz.irt.bo.profile.ProfileBoImp1;
import org.mz.irt.bo.uploadDocument.ClientProfileUploadDocumentBo;
import org.mz.irt.bo.uploadDocument.ClientProfileUploadDocumentBoImp1;
import org.mz.irt.model.Document;

/**
 *
 * @author metazone
 */
public class ProfilePanel extends javax.swing.JPanel {

    private final JFrame frame;
    private JLabel previewDocumentLbl;
    String gender;
    ArrayList<Document> documentList = new ArrayList<Document>();
    int i;
    /**
     * Creates new form FilePanel
     */
    public ProfilePanel(JFrame frame) {
        this.frame = frame;
        initComponents();
        createDocumentPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileTitleLbl = new javax.swing.JLabel();
        firstNameLbl = new javax.swing.JLabel();
        lastNameLbl = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        contactNumberLbl = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        emailIdLbl = new javax.swing.JLabel();
        emailIdTextField = new javax.swing.JTextField();
        addressLbl = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        stateLbl = new javax.swing.JLabel();
        aadharLbl = new javax.swing.JLabel();
        aadharTextField = new javax.swing.JTextField();
        createprofileBtn = new javax.swing.JButton();
        msgLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentsPanel = new javax.swing.JPanel();
        panNoLbl = new javax.swing.JLabel();
        panNoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phoneNumberLbl = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();

        profileTitleLbl.setText(" New Profile");

        firstNameLbl.setText("First Name");

        lastNameLbl.setText("Last Name");

        contactNumberLbl.setText("Contact Number");

        emailIdLbl.setText("EmailId");

        addressLbl.setText("Address");

        aadharLbl.setText("Aadhar Card No");

        createprofileBtn.setText("Create Profile");
        createprofileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createprofileBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("+91");

        documentsPanel.setLayout(new javax.swing.BoxLayout(documentsPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(documentsPanel);

        panNoLbl.setText("Pan No");

        jLabel2.setText("optional");

        phoneNumberLbl.setText("Phone Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profileTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(msgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(stateLbl)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(emailIdLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(132, 132, 132)
                                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(panNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(aadharLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(47, 47, 47)
                                            .addComponent(aadharTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(contactNumberLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(244, 244, 244)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(phoneNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(215, 215, 215))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(createprofileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(profileTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(msgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(stateLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(panNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aadharLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aadharTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createprofileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createprofileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createprofileBtnActionPerformed
        i=0;
        Profile profile = new Profile();
        profile.setFirstName(firstNameTextField.getText());
        profile.setLastName(lastNameTextField.getText());
        profile.setContactNumber(contactNumberTextField.getText());
        profile.setPhoneNumber(phoneNumberTextField.getText());
        //profile.setGender(gender);
        profile.setEmailId(emailIdTextField.getText());
        profile.setAddress(addressTextField.getText());
        //profile.setCity(cityTextField.getText());
        //profile.setState(stateTextField.getText());
        //profile.setPinNumber(pinNoTextField.getText());
        profile.setAadharCardNumber(aadharTextField.getText());
        profile.setPanNumber(panNoTextField.getText());
        ProfileBo profileBo = new ProfileBoImp1();
        if (!(documentList.isEmpty())) {
            ClientProfileUploadDocumentBo uploadDocumentBo = new ClientProfileUploadDocumentBoImp1();
            uploadDocumentBo.uploadDocument(documentList, aadharTextField.getText());
        }
        profile.setDocumentList(documentList);
        int result = profileBo.createProfile(profile);
        if (result > 0) {
            msgLbl.setText("Profile created");
            frame.setEnabled(true);
            this.getTopLevelAncestor().setVisible(false);
        } else {
            msgLbl.setText("Profile does not created");
        }
    }//GEN-LAST:event_createprofileBtnActionPerformed

    private void uploadDocument() {
        i++;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filePath = file.getAbsolutePath();
        Document document = new Document();
        document.setFile(file);
        int index=file.getName().indexOf(".");
        document.setFileName("document_"+i+"."+file.getName().substring(index));
//        FilenameFilter filter = new FilenameFilter() {
//            public boolean accept(File file,String name) {
//                return name.endsWith(".jpg") || name.endsWith(".pdf");
//            }
//        };
        documentList.add(document);
//        ClientProfileUploadDocumentBo uploadDocumentBo = new ClientProfileUploadDocumentBoImp1();
//        uploadDocumentBo.uploadDocument(document,aadharTextField.getText());
//        try {
//          JTextArea textArea=new JTextArea();
//          previewDocumentPanel.add(textArea);
//          System.out.println(file.getName());
//         FileReader fileReader=new FileReader(file);
//          System.out.println(fileReader);
//          textArea.read(fileReader,file);
//        } catch (IOException ex) {
//          System.out.println("problem accessing file"+file.getAbsolutePath());
//        }
        ImageIcon icon = new ImageIcon(filePath);
        Image img = icon.getImage();
        previewDocumentLbl.setIcon(new ImageIcon(scaledImage(img, previewDocumentLbl.getWidth(), previewDocumentLbl.getHeight())));
        createDocumentPanel();
    }

    void deleteDocument() {
        
    }

    private Image scaledImage(Image img, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, height, width, null);
        return bufferedImage;
    }

    private void createDocumentPanel() {
        JPanel documentPanel = new JPanel();
        JLabel previewDocumentLbl = new JLabel();
        this.previewDocumentLbl = previewDocumentLbl;
        JButton deleteBtn = new JButton("Delete");
        JButton uploadDocumentBtn = new JButton("Upload Documents");
        GroupLayout documentPanelLayout = new GroupLayout(documentPanel);
        documentPanel.setLayout(documentPanelLayout);
        documentPanelLayout.setHorizontalGroup(
                documentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(documentPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(uploadDocumentBtn)
                                .addGap(49, 49, 49)
                                .addComponent(previewDocumentLbl, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                //.addGap(69, 69, 69)
                                .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(160, Short.MAX_VALUE))
        );
        documentPanelLayout.setVerticalGroup(
                documentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(documentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(documentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(uploadDocumentBtn, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(previewDocumentLbl, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        uploadDocumentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadDocument();
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDocument();
            }
        });
        documentsPanel.add(documentPanel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aadharLbl;
    private javax.swing.JTextField aadharTextField;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel contactNumberLbl;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JButton createprofileBtn;
    private javax.swing.JPanel documentsPanel;
    private javax.swing.JLabel emailIdLbl;
    private javax.swing.JTextField emailIdTextField;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel msgLbl;
    private javax.swing.JLabel panNoLbl;
    private javax.swing.JTextField panNoTextField;
    private javax.swing.JLabel phoneNumberLbl;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel profileTitleLbl;
    private javax.swing.JLabel stateLbl;
    // End of variables declaration//GEN-END:variables
}
