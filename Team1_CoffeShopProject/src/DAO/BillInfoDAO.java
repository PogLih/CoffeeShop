/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.BillInfo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Minh
 */
public class BillInfoDAO {

    public void insert(int idBill, int idDrinks, int Quantity,float Price) {
        try {
            String sql = "INSERT INTO BillInfo (idBill,idDrinks,Quantity,Price) VALUES (?, ?, ?, ?)";
            JdbcHelper.executeUpdate(sql,
                    idBill,
                    idDrinks,
                    Quantity,
                    Price);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(BillInfo model) {
        try {
            String sql = "UPDATE BillInfo SET idBill=?, idDrinks=?, CountItem=? WHERE id=?";
            JdbcHelper.executeUpdate(sql,
                    model.getIdBill(),
                    model.getIdDrinks(),
                    model.getQuantity(),
                    model.getPrice());
        } catch (Exception e) {
            System.out.println("Loi update");
        }
    }

    public void delete(String id) {
        try {
            String sql = "DELETE FROM BillInfo WHERE id=?";
            JdbcHelper.executeUpdate(sql, id);
        } catch (Exception e) {
            System.out.println("Loi xoa");
        }
    }

    public boolean IsNumber(String num) {
        if (num == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public List<BillInfo> findbyid(String bi) {
        try {
            String sql = "select * from BillInfo";
            if (bi.length() > 0) {
                if (IsNumber(bi) == true) {
                    sql += "where id like %'" + bi + "'%";
                }
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<BillInfo> list = new ArrayList<BillInfo>();
            while (rs.next()) {
                int idbill = rs.getInt("idBill");
                int iddrink = rs.getInt("idDrinks");
                int Quantity = rs.getInt("Quantity");
                float price = rs.getFloat("Price");
                BillInfo tc = new BillInfo(idbill, iddrink, Quantity,price);
                list.add(tc);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    

}
