/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

import dao.newpackage.BillItemDao;
import model.Bill;
import model.BillItem;
import java.awt.*;
import java.awt.print.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class ViewBillReceipt extends javax.swing.JFrame {
    private Bill bill;
    private ArrayList<BillItem> items;

    public ViewBillReceipt() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public ViewBillReceipt(Bill bill) {
        initComponents();
        setLocationRelativeTo(null);
        this.bill = bill;
        this.items = BillItemDao.getItemsByBillId(bill.getId());
        displayBill();
    }

    private void displayBill() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n");
        receipt.append("═══════════════════════════════════════════════════════════\n");
        receipt.append("                  ☕ CAFE MANAGEMENT SYSTEM ☕\n");
        receipt.append("═══════════════════════════════════════════════════════════\n\n");

        receipt.append(String.format("  Bill ID: #%03d%n", bill.getId()));
        receipt.append(String.format("  Date: %s%n", bill.getDate()));
        receipt.append(String.format("  Customer: %s%n", bill.getEmail()));
        receipt.append(String.format("  Served By: %s%n", bill.getCreatedBy()));

        receipt.append("\n───────────────────────────────────────────────────────────\n");
        receipt.append(String.format("  %-25s %5s %10s %12s%n", "ITEM", "QTY", "PRICE", "TOTAL"));
        receipt.append("───────────────────────────────────────────────────────────\n");

        double subtotal = 0.0;
        for (BillItem item : items) {
            String productName = item.getProductName();
            if (productName.length() > 25) {
                productName = productName.substring(0, 22) + "...";
            }
            receipt.append(String.format("  %-25s %5d %10s %12s%n",
                    productName,
                    item.getQuantity(),
                    item.getPrice(),
                    item.getTotal()));
            subtotal += Double.parseDouble(item.getTotal());
        }

        receipt.append("───────────────────────────────────────────────────────────\n\n");

        // Calculate tax (5%)
        double tax = subtotal * 0.05;
        double grandTotal = subtotal + tax;

        receipt.append(String.format("  %45s %12.2f%n", "SUBTOTAL:", subtotal));
        receipt.append(String.format("  %45s %12.2f%n", "TAX (5%):", tax));
        receipt.append("  ─────────────────────────────────────────────────────────\n");
        receipt.append(String.format("  %45s %12.2f%n", "GRAND TOTAL:", grandTotal));

        receipt.append("\n═══════════════════════════════════════════════════════════\n");
        receipt.append("                  Thank You For Your Visit!\n");
        receipt.append("                    Please Come Again! 😊\n");
        receipt.append("═══════════════════════════════════════════════════════════\n");

        jTextArea1.setText(receipt.toString());
        jTextArea1.setCaretPosition(0);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bill Receipt");

        jLabel1.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILL RECEIPT");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 240));
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Print Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(20, 20, 20)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(20, Short.MAX_VALUE)));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            jTextArea1.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error printing: " + e.getMessage());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBillReceipt.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBillReceipt.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBillReceipt.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBillReceipt.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBillReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
