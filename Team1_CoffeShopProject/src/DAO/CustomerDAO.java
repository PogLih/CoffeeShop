/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linh
 */
public class CustomerDAO {

    public void Insert(String phone, String name, int point) {
        try {
            String sql = "Insert into dbo.Customer(phone,name,point) values (?,?,?)";
            JdbcHelper.executeUpdate(sql, phone,name,point);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(String phone) {
        try {
            String sql = "Delete from dbo.Customer where phone = ?";
            JdbcHelper.executeUpdate(sql, phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(Customer model) {
        try {
            String sql = "Update dbo.Customer set name = ? , point = ? where phone = ?";
            JdbcHelper.executeUpdate(sql, model.getName(), model.getPoint(), model.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<Customer> findbyid(String tk) {
        try {
            String sql = "select * from Customer";
            if (tk.length() > 0) {
                if (IsNumber(tk) == true) {
                    sql += " where Phone like '%" + tk + "%'";
                } else {
                    sql += " where Name like '%" + tk + "%'";
                }
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Customer> list = new ArrayList<Customer>();
            while (rs.next()) {
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                Integer point = Integer.parseInt(rs.getString("point"));
                Customer kh = new Customer(phone, name, point);
                list.add(kh);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public boolean check(String phone)
    {
        String sql="select * from customer where phone like ?";
        ResultSet rs=JdbcHelper.executeQuery(sql, phone);
        try {
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
