/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.newpackage;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class tables {
    public static void main(String[] args) {
        try {
            String userTable = "Create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','pakistan','admin','What primary school did you attend?','abc','true')";
            String categoryTable = "Create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable = "Create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable = "Create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            String billItemsTable = "Create table bill_items(id int AUTO_INCREMENT primary key,bill_id int,product_name varchar(200),quantity int,price varchar(200),total varchar(200))";
            DbOperations.setDataorDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataorDelete(adminDetails, "Admin details Created Successfully");
            DbOperations.setDataorDelete(categoryTable, "Category Table Created Successfully");
            DbOperations.setDataorDelete(productTable, "Product Table Created Successfully");
            DbOperations.setDataorDelete(billTable, "Bill Table Created Successfully");
            DbOperations.setDataorDelete(billItemsTable, "Bill Items Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
