/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.newpackage;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author USER
 */
public class Userdao {
    public static void save(User user) {
        String query = "insert into user (Name,email,mobileNumber,address,password,securityQuestion,Answer,Status) values('"
                + user.getName() + "','" + user.getMail() + "','" + user.getMobileNumber() + "','" + user.getAddress()
                + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer()
                + "','False')";
        DbOperations.setDataorDelete(query, "Registered successfully! Wait for Admin Approval!");
    }

    public static User Login(String mail, String Password) {
        User user = null;
        try {
            ResultSet rs = DbOperations
                    .getData("select * from user where email='" + mail + "' and password='" + Password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setMail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void changeStatus(String email, String status) {
        String query = "update user set status='" + status + "' where email='" + email + "'";
        DbOperations.setDataorDelete(query, "Status Changed Successfully");
    }

    public static void changePassword(String email, String newPassword) {
        String query = "update user set password='" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataorDelete(query, "Password Changed Successfully");
    }

    public static void changeSecurityQuestion(String email, String securityQuestion, String answer) {
        String query = "update user set securityQuestion='" + securityQuestion + "', answer='" + answer
                + "' where email='" + email + "'";
        DbOperations.setDataorDelete(query, "Security Question Changed Successfully");
    }

}
