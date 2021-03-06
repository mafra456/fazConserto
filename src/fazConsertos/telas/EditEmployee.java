/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fazConsertos.telas;

import java.sql.*;
import fazConsertos.DAL.ConnectionModule;
import javax.swing.JOptionPane;

public class EditEmployee extends javax.swing.JInternalFrame {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void start() {
        String sql = "select * from employee where idemp=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Integer.toString(TelaLogin.id));
            rs = pst.executeQuery();
            if (rs.next()) {
                nameEmployee.setText(rs.getString(2));
                phoneEmployee.setText(rs.getString(3));
                addressEmployee.setText(rs.getString(4));
                cpfEmployee.setText(rs.getString(6));
                emailEmployee.setText(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível recuperar seus dados. Por favor, faça o login novamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void updateEmployee() {
        String sql = "update employee set name_emp=?, phone=?, address=?, email=?, cpf=?, profession=?, passwd=?"
                + "where idemp=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nameEmployee.getText());
            pst.setString(2, phoneEmployee.getText());
            pst.setString(3, addressEmployee.getText());
            pst.setString(4, emailEmployee.getText());
            pst.setString(5, cpfEmployee.getText());
            pst.setString(6, professionEmployee.getSelectedItem().toString());
            pst.setString(7, passwordEmployee.getText());
            pst.setString(8, Integer.toString(TelaLogin.id));
            if (nameEmployee.getText().isEmpty() || addressEmployee.getText().isEmpty() || phoneEmployee.getText().isEmpty()
                    || passwordEmployee.getText().isEmpty() || cpfEmployee.getText().isEmpty() || emailEmployee.getText().isEmpty()
                    || professionEmployee.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todo o formulário");
            } else {
                int registered = pst.executeUpdate();
                if (registered > 0) {
                    JOptionPane.showMessageDialog(null, "Atualização feita com sucesso");
                }
                pst.close();
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public EditEmployee() {
        connection = ConnectionModule.connector();
        initComponents();
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
        nameEmployee = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        addressEmployee = new javax.swing.JTextField();
        phone = new javax.swing.JLabel();
        phoneEmployee = new javax.swing.JTextField();
        cpf = new javax.swing.JLabel();
        cpfEmployee = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailEmployee = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passwordEmployee = new javax.swing.JPasswordField();
        profession = new javax.swing.JLabel();
        professionEmployee = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(935, 460));

        name.setText("Nome:");

        address.setText("Endereço:");

        phone.setText("Telefone:");

        cpf.setText("CPF:");

        email.setText("Email:");

        password.setText("Senha:");

        passwordEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordEmployeeActionPerformed(evt);
            }
        });

        profession.setText("Habilidade:");

        professionEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpeza", "Bombeiro", "Pedreiro", "Eletricista" }));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profession)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(professionEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(address)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addressEmployee))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(name)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email)
                            .addComponent(password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailEmployee)
                            .addComponent(passwordEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))))
                .addContainerGap(277, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(nameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address)
                    .addComponent(addressEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone)
                    .addComponent(phoneEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf)
                    .addComponent(cpfEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profession)
                    .addComponent(professionEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(cancel))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordEmployeeActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateEmployee();
        this.dispose();
    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressEmployee;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cpf;
    private javax.swing.JTextField cpfEmployee;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailEmployee;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameEmployee;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordEmployee;
    private javax.swing.JLabel phone;
    private javax.swing.JTextField phoneEmployee;
    private javax.swing.JLabel profession;
    private javax.swing.JComboBox<String> professionEmployee;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
