/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import org.mz.irt.bo.company.CompanyBo;
import org.mz.irt.bo.company.CompanyBoImp1;
import org.mz.irt.bo.makeInvestment.MakeInvestmentBo;
import org.mz.irt.bo.makeInvestment.MakeInvestmentBoImp1;

/**
 *
 * @author metazone
 */
public class InvestmentPanel extends javax.swing.JPanel {
    private final JFrame frame;
    private final String aadharNo;
    /**
     * Creates new form GetAadharPanel
     */
    public InvestmentPanel(JFrame frame,String aadharNo) {
        this.frame = frame;
        this.aadharNo=aadharNo;
        initComponents();
        JPanel makeInvestmentPanel = createPanel();
        investmentPanel.add(makeInvestmentPanel);
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        companyNameLbl = new javax.swing.JLabel();
        investmentLbl = new javax.swing.JLabel();
        investmentResultLbl = new javax.swing.JLabel();
        moreBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        investmentPanel = new javax.swing.JPanel();

        companyNameLbl.setText("Select Company Name");

        investmentLbl.setText("Investment");

        moreBtn.setText("+");
        moreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreBtnActionPerformed(evt);
            }
        });

        investmentPanel.setLayout(new javax.swing.BoxLayout(investmentPanel, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(investmentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(companyNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(investmentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(moreBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(investmentResultLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(investmentResultLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(investmentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(moreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private JPanel createPanel() {
        JPanel makeInvestmentPanel = new JPanel();
        JComboBox companyNameDropDown = new JComboBox();
        CompanyBo companyBo=new CompanyBoImp1();
        ArrayList<String> companyNameList=companyBo.getCompaniesName();
        for(String companyName:companyNameList)
        companyNameDropDown.addItem(companyName);
        //companyNameDropDown.setSize(20, 20);
        NumberFormatter formatter = new NumberFormatter(); 
        formatter.setAllowsInvalid(false); 
        JFormattedTextField investmentTextField = new JFormattedTextField(formatter);
        JButton addInvestmentBtn = new JButton("Add");
        addInvestmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeInvestmentBo makeInvestmentBo = new MakeInvestmentBoImp1();
                int result = makeInvestmentBo.addInvestment(companyNameDropDown.getSelectedItem().toString(), investmentTextField.getText(),aadharNo);
                if (result > 0) {
                    investmentResultLbl.setText("successfully added");
                } else {
                    investmentResultLbl.setText("Error to make investment");
                }
            }
        });
        GroupLayout makeInvestmentPanelLayout = new GroupLayout(makeInvestmentPanel);
        makeInvestmentPanel.setLayout(makeInvestmentPanelLayout);
        makeInvestmentPanelLayout.setHorizontalGroup(
                makeInvestmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(makeInvestmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(companyNameDropDown, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(investmentTextField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addInvestmentBtn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        makeInvestmentPanelLayout.setVerticalGroup(
                makeInvestmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(makeInvestmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(makeInvestmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(companyNameDropDown, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(investmentTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addInvestmentBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return makeInvestmentPanel;
    }
    
    private void moreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreBtnActionPerformed
        JPanel makeInvestmentPanel = createPanel();
        //investmentPanel.setSize(new Dimension(investmentPanel.getPreferredSize().width,investmentPanel.getPreferredSize().height));
        //JScrollPane scrollPane=new JScrollPane(investmentPanel);
        //investmentPanel.setLayout(new BoxLayout(investmentPanel,BoxLayout.Y_AXIS));
        //scrollPane.setLocation(20,100);
        //this.add(scrollPane);
        investmentPanel.add(makeInvestmentPanel);
        revalidate();
        //this.getTopLevelAncestor().setSize(400,this.getTopLevelAncestor().getHeight()+150);
        //JScrollPane scrollPane=new JScrollPane();
        //scrollPane.setAutoscrolls(true);
        //scrollPane.add(investmentPanel);
        //makeInvestPanel.setMinimumSize(new Dimension(makeInvestPanel.getPreferredSize().width,makeInvestPanel.getPreferredSize().height));
        //makeInvestPanel.setMaximumSize(new Dimension(makeInvestPanel.getPreferredSize().width,120));
        //investmentPanel.add(makeInvestPanel);
        //System.out.println(investmentPanel.getWidth()+" "+investmentPanel.getHeight());
        //makeInvestPanel.setSize(makeInvestPanel.getWidth(),makeInvestPanel.getHeight());
        //makeInvestPanel.setLocation(makeInvestmentPanel.getX(),makeInvestmentPanel.getY());
        //investmentPanel.setSize(investmentPanel.getWidth(),investmentPanel.getHeight()+makeInvestmentPanel.getHeight()+20);
        //        System.out.println(investmentPanel.getWidth()+" "+investmentPanel.getHeight());
        //        makeInvestPanel.setSize(makeInvestmentPanel.getWidth(),makeInvestmentPanel.getHeight());
        //        makeInvestPanel.setLocation(makeInvestmentPanel.getX(),makeInvestmentPanel.getY()+20);
        //        investmentPanel.add(makeInvestPanel);
        //        System.out.println(moreBtn.getX()+" "+moreBtn.getY());
        //        System.out.println(makeInvestmentPanel.getWidth()+" "+makeInvestmentPanel.getHeight());
        //        moreBtn.setLocation(moreBtn.getX(),investmentPanel.getY()+20);
        //        makeInvestmentPanel.setLocation(moreBtn.getX(),moreBtn.getY()-35);
        //        moreBtn.setLocation(makeInvestmentPanel.getX(),makeInvestmentPanel.getY()+50);
        //        System.out.println(makeInvestmentPanel.getX()+" "+makeInvestmentPanel.getY());
        //        moreBtn.setLocation(moreBtn.getX(),moreBtn.getY()+150);
        //        investmentPanel.setSize(investmentPanel.getWidth(),investmentPanel.getHeight()+100);
        //        makeInvestmentPanel.setSize(investmentPanel.getWidth(),90);
        //        makeInvestmentPanel.setLocation(,);
        //        investmentPanel.add(makeInvestPanel);
        //        makeInvestmentPanel.setBounds(moreBtn.getX(),moreBtn.getY(),400,100);
        //        moreBtn.setLocation(moreBtn.getX(),moreBtn.getY()+20);
        //        moreBtn.setLocation();
        //        moreBtn.setBounds(moreBtn.getX(),moreBtn.getY()+20, moreBtn.getWidth(),moreBtn.getHeight());
        //        moreBtn.setBounds(20,150,10,10);
        //        System.out.println(moreBtn.getX()+" "+moreBtn.getY());
        //
    }//GEN-LAST:event_moreBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel companyNameLbl;
    private javax.swing.JLabel investmentLbl;
    private javax.swing.JPanel investmentPanel;
    private javax.swing.JLabel investmentResultLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moreBtn;
    // End of variables declaration//GEN-END:variables
}
