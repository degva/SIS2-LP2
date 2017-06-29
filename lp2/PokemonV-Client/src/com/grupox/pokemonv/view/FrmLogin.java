/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.view;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.Sound;
import com.grupox.pokemonv.model.SpriteSheet;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author alulab14
 */
public class FrmLogin extends javax.swing.JFrame {

    Game game;
    /**
     * Creates new form FrmLogin
     */
    private int a = 0;
    
    public FrmLogin() {
        Sound.getInstance().start(Sound.AUDIO.INTRO);
        initComponents();
        this.setIconImage(SpriteSheet.getInstance().getSubImage(7, 0));
        this.game = game;
        setVisible(true);
        
        setTitle("Login");
        setLocation(550,350);
    }
    
    
    public boolean camposValidos(){
        
        if(TXTusername.getText().equals("")){
            showMessageDialog(null, "Must enter an username");
            return false;
        }else if(TXTpassword.getText().equals("")){
            showMessageDialog(null, "Must enter a password");
            return false;
        }else if(TXTusername.getText().equals(" ") || 
                TXTpassword.getText().equals(" ") || TXTusername.getText().equals('"') || 
                TXTpassword.getText().equals('"') )
        {
            showMessageDialog(null, "");
            return false;
        }
        return true;
    }
    
    public void logueo(){
        if(!camposValidos()) return ;
        DataAccess playeradmin = new DataAccess();
        
        if(playeradmin.verifyLogin(TXTusername.getText(), TXTpassword.getText()) == 1){
            setA(1);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BTNlogin = new javax.swing.JButton();
        BTNregister = new javax.swing.JButton();
        TXTusername = new javax.swing.JTextField();
        TXTpassword = new javax.swing.JPasswordField();
        LBLpassword = new javax.swing.JLabel();
        LBLusername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        BTNlogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        BTNlogin.setText("Login");
        BTNlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNloginActionPerformed(evt);
            }
        });
        jPanel1.add(BTNlogin);
        BTNlogin.setBounds(180, 300, 90, 30);

        BTNregister.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        BTNregister.setText("Register");
        BTNregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNregisterActionPerformed(evt);
            }
        });
        jPanel1.add(BTNregister);
        BTNregister.setBounds(390, 300, 110, 30);

        TXTusername.setToolTipText("");
        jPanel1.add(TXTusername);
        TXTusername.setBounds(310, 220, 130, 20);
        jPanel1.add(TXTpassword);
        TXTpassword.setBounds(310, 260, 130, 20);

        LBLpassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLpassword.setText("Password");
        jPanel1.add(LBLpassword);
        LBLpassword.setBounds(170, 260, 90, 20);

        LBLusername.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLusername.setText("Username");
        jPanel1.add(LBLusername);
        LBLusername.setBounds(170, 220, 90, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNloginActionPerformed
        logueo();
    }//GEN-LAST:event_BTNloginActionPerformed

    private void BTNregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNregisterActionPerformed
        FrmRegister frame = new FrmRegister();
        frame.setVisible(true);
    }//GEN-LAST:event_BTNregisterActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmLogin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNlogin;
    private javax.swing.JButton BTNregister;
    private javax.swing.JLabel LBLpassword;
    private javax.swing.JLabel LBLusername;
    private javax.swing.JPasswordField TXTpassword;
    private javax.swing.JTextField TXTusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }
}
