/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.view;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.model.SpriteSheet;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author alulab14
 */
public class FrmRegister extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegister
     */
    public FrmRegister() {
        initComponents();
        this.setIconImage(SpriteSheet.getInstance().getSubImage(7, 0));
        
        setTitle("Register");
        setLocation(550,350);
        
        close();
        
    }
    
    
    public void comprobarCorreo(String txt){
        
        String cad1 = "@pucp.pe";
        String cad2 = "@pucp.edu.pe";
        String cad3 = "@gmail.com";
        String cad4 = "@hotmail.com";
        
        if(!((txt.toLowerCase().contains(cad1)) || (txt.toLowerCase().contains(cad2))
                || (txt.toLowerCase().contains(cad3)) || (txt.toLowerCase().contains(cad4)))){
            showMessageDialog(null, " Invalid email");
        }
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
                TXTpassword.getText().equals('"') ){
            showMessageDialog(null, "Quotation marks and spaces are not allowed");
            return false;
        }else if(TXTname.getText().equals("")){
            showMessageDialog(null, "Must enter a name");
            return false;
        }else if(TXTemail.getText().equals("")){
            showMessageDialog(null, "Must enter an email");
            return false;
        }
        
        comprobarCorreo(TXTemail.getText());
        DataAccess playerAdmin = new DataAccess();
        if(playerAdmin.verifyUsername(TXTusername.getText()) == 1){
            showMessageDialog(null, "That username has already been registered");
            return false;
        }
        
        if(playerAdmin.verifyEmail(TXTemail.getText()) == 1){
            showMessageDialog(null, "That email has already been registered");
            return false;
        }
        
        return true;
    }
    
    
    public void close(){
        
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
               public void windowClosing(WindowEvent e){
                   confirm();
               } 
            });
            this.setVisible(true);
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
    
    public void confirm(){
        int value = JOptionPane.showConfirmDialog(this, "¿Ya no deseas registrarte?", "Warning", JOptionPane.YES_NO_OPTION);
        if(value == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }
    }
    
    public void register(){
        if(!camposValidos()) return ;
        DataAccess playeradmin = new DataAccess();
        
        if(playeradmin.addPlayer(TXTname.getText(), TXTusername.getText(), TXTpassword.getText(), TXTemail.getText()) == 1){
            setVisible(false);
        }else {
             showMessageDialog(null, "Cant registered");
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
        LBLname = new javax.swing.JLabel();
        LBLemail = new javax.swing.JLabel();
        TXTusername = new javax.swing.JTextField();
        TXTname = new javax.swing.JTextField();
        TXTpassword = new javax.swing.JPasswordField();
        TXTemail = new javax.swing.JTextField();
        BTNregister = new javax.swing.JButton();
        BTNcancel = new javax.swing.JButton();
        LBLpassword = new javax.swing.JLabel();
        LBLusername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        LBLname.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLname.setText("Name");
        jPanel1.add(LBLname);
        LBLname.setBounds(110, 100, 90, 30);

        LBLemail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLemail.setText("Email");
        jPanel1.add(LBLemail);
        LBLemail.setBounds(110, 250, 90, 30);
        jPanel1.add(TXTusername);
        TXTusername.setBounds(230, 150, 130, 30);
        jPanel1.add(TXTname);
        TXTname.setBounds(230, 100, 130, 30);
        jPanel1.add(TXTpassword);
        TXTpassword.setBounds(230, 200, 130, 30);

        TXTemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTemailKeyTyped(evt);
            }
        });
        jPanel1.add(TXTemail);
        TXTemail.setBounds(230, 250, 130, 30);

        BTNregister.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BTNregister.setText("Register");
        BTNregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNregisterActionPerformed(evt);
            }
        });
        jPanel1.add(BTNregister);
        BTNregister.setBounds(130, 320, 100, 30);

        BTNcancel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BTNcancel.setText("Cancel");
        BTNcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcancelActionPerformed(evt);
            }
        });
        jPanel1.add(BTNcancel);
        BTNcancel.setBounds(330, 320, 100, 30);

        LBLpassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLpassword.setText("Password");
        jPanel1.add(LBLpassword);
        LBLpassword.setBounds(110, 200, 90, 30);

        LBLusername.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LBLusername.setText("Username");
        jPanel1.add(LBLusername);
        LBLusername.setBounds(110, 150, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pikachu (1).jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNregisterActionPerformed
        register();
    }//GEN-LAST:event_BTNregisterActionPerformed

    private void BTNcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BTNcancelActionPerformed

    private void TXTemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTemailKeyTyped
        char keypressed = evt.getKeyChar();
        
        if(keypressed == KeyEvent.VK_ENTER){
            register();
        }
    }//GEN-LAST:event_TXTemailKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegister().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNcancel;
    private javax.swing.JButton BTNregister;
    private javax.swing.JLabel LBLemail;
    private javax.swing.JLabel LBLname;
    private javax.swing.JLabel LBLpassword;
    private javax.swing.JLabel LBLusername;
    private javax.swing.JTextField TXTemail;
    private javax.swing.JTextField TXTname;
    private javax.swing.JPasswordField TXTpassword;
    private javax.swing.JTextField TXTusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
