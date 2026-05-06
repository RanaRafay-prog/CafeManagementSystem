/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

/**
 *
 * @author USER
 */
public class Home extends javax.swing.JFrame {
    private String userEmail = "";
    private boolean isAdmin = false;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public Home(String email, boolean admin) {
        initComponents();
        setLocationRelativeTo(null);
        this.userEmail = email;
        this.isAdmin = admin;
        jLabel1.setText("Welcome: " + email);

        // Hide admin/staff buttons if not admin
        if (!isAdmin) {
            btnManageCategory.setVisible(false);
            btnAddProduct.setVisible(false);
            btnViewEditProduct.setVisible(false);
            btnViewBills.setVisible(false); // Admins see all bills
            btnViewMyOrders.setVisible(true); // Users see only their orders
            btnVerifyUsers.setVisible(false);
        } else {
            btnViewMyOrders.setVisible(false); // Admins don't need "My Orders"
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnManageCategory = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnViewEditProduct = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        btnViewBills = new javax.swing.JButton();
        btnViewMyOrders = new javax.swing.JButton();
        btnVerifyUsers = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafe Management System - Home");

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("Cafe Management System");

        btnManageCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageCategory.setText("Manage Category");
        btnManageCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCategoryActionPerformed(evt);
            }
        });

        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProduct.setText("Add New Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnViewEditProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewEditProduct.setText("View/Edit/Delete Product");
        btnViewEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEditProductActionPerformed(evt);
            }
        });

        btnPlaceOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        btnViewBills.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewBills.setText("View Bills & Orders");
        btnViewBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBillsActionPerformed(evt);
            }
        });

        btnViewMyOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewMyOrders.setText("View My Orders");
        btnViewMyOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMyOrdersActionPerformed(evt);
            }
        });

        btnVerifyUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerifyUsers.setText("Verify Users (Admin)");
        btnVerifyUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyUsersActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewBills, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewMyOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnVerifyUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnManageCategory)
                                .addGap(15, 15, 15)
                                .addComponent(btnAddProduct)
                                .addGap(15, 15, 15)
                                .addComponent(btnViewEditProduct)
                                .addGap(15, 15, 15)
                                .addComponent(btnPlaceOrder)
                                .addGap(15, 15, 15)
                                .addComponent(btnViewBills)
                                .addGap(15, 15, 15)
                                .addComponent(btnViewMyOrders)
                                .addGap(15, 15, 15)
                                .addComponent(btnVerifyUsers)
                                .addGap(15, 15, 15)
                                .addComponent(btnLogout)
                                .addContainerGap(30, Short.MAX_VALUE)));

        pack();
    }

    private void btnManageCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        new ManageCategory().setVisible(true);
    }

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {
        new AddNewProduct().setVisible(true);
    }

    private void btnViewEditProductActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewEditDeleteProduct().setVisible(true);
    }

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {
        new PlaceOrder(userEmail).setVisible(true);
    }

    private void btnViewBillsActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewBillsOrderPlacedDetails().setVisible(true);
    }

    private void btnViewMyOrdersActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewMyOrders(userEmail).setVisible(true);
    }

    private void btnVerifyUsersActionPerformed(java.awt.event.ActionEvent evt) {
        new VerifyUsers().setVisible(true);
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new login().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCategory;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnVerifyUsers;
    private javax.swing.JButton btnViewBills;
    private javax.swing.JButton btnViewEditProduct;
    private javax.swing.JButton btnViewMyOrders;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration
}
