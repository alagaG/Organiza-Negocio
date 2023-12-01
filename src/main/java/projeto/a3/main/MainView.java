/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto.a3.main;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import projeto.a3.ConnectionFactory;
import projeto.a3.controller.NoteController;
import projeto.a3.controller.UserController;
import projeto.a3.model.NoteModel;
import projeto.a3.model.UserModel;
import projeto.a3.view.NoteView;

/**
 *
 * @author pc
 */
public class MainView extends javax.swing.JFrame {

    private static MainView instance;
    private static UserModel user;
    private UserController controller = new UserController();
    
    /**
     * Creates new form MainFrame
     */
    public MainView() {
        instance = this;
        user = controller.read("Teste", "123");
        while (user == null) {
            String username = JOptionPane.showInputDialog("Insira o nome de usuário: ");
            if (username == null) break;
            String password = JOptionPane.showInputDialog("Insira a senha: ");
            if (password == null) break;
            user = controller.read(username, password);
            System.out.println(user);
        }
        if (user != null) {
            initComponents();
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

        cardPanel = new javax.swing.JPanel();
        schedule = new projeto.a3.view.ScheduleView();
        costumer = new projeto.a3.view.CostumerView();
        employee = new projeto.a3.view.EmployeeView();
        note = new projeto.a3.view.NoteView();
        menuBar = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        notesLink = new javax.swing.JMenuItem();
        costumerLink = new javax.swing.JMenuItem();
        employeeLink = new javax.swing.JMenuItem();
        scheduleLink = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(schedule, "schedule");

        costumer.setName("costumer"); // NOI18N
        cardPanel.add(costumer, "costumer");

        employee.setName("employee"); // NOI18N
        cardPanel.add(employee, "employee");

        note.setName("note"); // NOI18N
        cardPanel.add(note, "note");

        jMenu3.setText("jMenu3");

        notesLink.setText("Notas");
        notesLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesLinkActionPerformed(evt);
            }
        });
        jMenu3.add(notesLink);

        costumerLink.setText("Clientes");
        costumerLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costumerLinkActionPerformed(evt);
            }
        });
        jMenu3.add(costumerLink);

        employeeLink.setText("Funcionários");
        employeeLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeLinkActionPerformed(evt);
            }
        });
        jMenu3.add(employeeLink);

        scheduleLink.setText("Agenda");
        scheduleLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleLinkActionPerformed(evt);
            }
        });
        jMenu3.add(scheduleLink);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notesLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesLinkActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        note.updateView();
        layout.show(cardPanel, note.getName());
    }//GEN-LAST:event_notesLinkActionPerformed

    private void costumerLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costumerLinkActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        costumer.updateView();
        layout.show(cardPanel, costumer.getName());
    }//GEN-LAST:event_costumerLinkActionPerformed

    private void employeeLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeLinkActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, employee.getName());
    }//GEN-LAST:event_employeeLinkActionPerformed

    private void scheduleLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleLinkActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, schedule.getName());
    }//GEN-LAST:event_scheduleLinkActionPerformed

    public static UserModel getUser() {
        return user;
    }
    
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView main = new MainView();
                main.setVisible(true);
                if (MainView.getUser() == null) main.dispose();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private projeto.a3.view.CostumerView costumer;
    private javax.swing.JMenuItem costumerLink;
    private projeto.a3.view.EmployeeView employee;
    private javax.swing.JMenuItem employeeLink;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar menuBar;
    private projeto.a3.view.NoteView note;
    private javax.swing.JMenuItem notesLink;
    private projeto.a3.view.ScheduleView schedule;
    private javax.swing.JMenuItem scheduleLink;
    // End of variables declaration//GEN-END:variables
}
