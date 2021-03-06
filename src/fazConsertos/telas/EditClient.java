/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fazConsertos.telas;

import java.sql.*;
import fazConsertos.DAL.ConnectionModule;
import javax.swing.JOptionPane;

public class EditClient extends javax.swing.JInternalFrame {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void start() {
        String sql = "select * from client where idclient=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Integer.toString(TelaLogin.id));
            rs = pst.executeQuery();
            if (rs.next()) {
                nameClient.setText(rs.getString(2));
                addressClient.setText(rs.getString(3));
                phoneClient.setText(rs.getString(4));
                rgClient.setText(rs.getString(5));
                cpfClient.setText(rs.getString(6));
                emailClient.setText(rs.getString(7));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível recuperar seus dados. Por favor, faça o login novamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void updateClient() {
        String sql = "update client set nameclient=?, address=?, phone=?, rg=?, cpf=?, email=?, passwd=?"
                + "where idclient=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nameClient.getText());
            pst.setString(2, addressClient.getText());
            pst.setString(3, phoneClient.getText());
            pst.setString(4, rgClient.getText());
            pst.setString(5, cpfClient.getText());
            pst.setString(6, emailClient.getText());
            pst.setString(7, passwordClient.getText());
            pst.setString(8, Integer.toString(TelaLogin.id));
            if (nameClient.getText().isEmpty() || addressClient.getText().isEmpty() || phoneClient.getText().isEmpty()
                    || rgClient.getText().isEmpty() || cpfClient.getText().isEmpty() || emailClient.getText().isEmpty()
                    || passwordClient.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todo o formulário");
            } else {
                int updated = pst.executeUpdate();
                if(updated > 0){
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso");
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public EditClient() {
        initComponents();
        connection = ConnectionModule.connector();
        start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        rg = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        nameClient = new javax.swing.JTextField();
        addressClient = new javax.swing.JTextField();
        phoneClient = new javax.swing.JTextField();
        rgClient = new javax.swing.JTextField();
        cpfClient = new javax.swing.JTextField();
        emailClient = new javax.swing.JTextField();
        passwordClient = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Editar Cadastro");
        setPreferredSize(new java.awt.Dimension(935, 460));

        name.setText("Nome:");

        address.setText("Endereço:");

        phone.setText("Telefone:");

        rg.setText("RG:");

        cpf.setText("CPF:");

        email.setText("Email:");

        password.setText("Senha:");

        update.setText("Atualizar");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordClient, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailClient, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rgClient, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfClient, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(address)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressClient, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(345, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(nameClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address)
                    .addComponent(addressClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone)
                    .addComponent(phoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rg)
                    .addComponent(rgClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(cancel))
                .addGap(38, 38, 38))
        );

        setBounds(0, 0, 935, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateClient();
    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressClient;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cpf;
    private javax.swing.JTextField cpfClient;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailClient;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameClient;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordClient;
    private javax.swing.JLabel phone;
    private javax.swing.JTextField phoneClient;
    private javax.swing.JLabel rg;
    private javax.swing.JTextField rgClient;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
