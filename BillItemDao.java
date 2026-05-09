/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.newpackage;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.BillItem;

/**
 *
 * @author USER
 */
public class BillItemDao {

    public static void save(BillItem item) {
        String query = "insert into bill_items(bill_id,product_name,quantity,price,total) values('" + item.getBillId()
                + "','" + item.getProductName() + "','" + item.getQuantity() + "','" + item.getPrice() + "','"
                + item.getTotal() + "')";
        DbOperations.setDataorDelete(query, "");
    }

    public static ArrayList<BillItem> getItemsByBillId(int billId) {
        ArrayList<BillItem> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from bill_items where bill_id='" + billId + "'");
            while (rs.next()) {
                BillItem item = new BillItem();
                item.setId(rs.getInt("id"));
                item.setBillId(rs.getInt("bill_id"));
                item.setProductName(rs.getString("product_name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getString("price"));
                item.setTotal(rs.getString("total"));
                arrayList.add(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
