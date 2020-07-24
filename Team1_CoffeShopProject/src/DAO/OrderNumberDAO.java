/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.OrderNumber;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Linh
 */
public class OrderNumberDAO {

    public void Insert(int id,boolean status) {
        try {
            String sql = "Insert into OrderNumber values (?,?)";
            JdbcHelper.executeUpdate(sql, id,status);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Delete(int id) {
        try {
            String sql = "Delete from OrderNumber where id = ?";
            JdbcHelper.executeUpdate(sql, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Update(OrderNumber model) {
        try {
            String sql = "Update OrderNumber set status = ? where id = ?";
            if(model.isStatus())
            JdbcHelper.executeUpdate(sql,1, model.getId());
            else
                JdbcHelper.executeUpdate(sql,0, model.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public List<OrderNumber> findbyid(String tb) {
        try {
            String sql = "select * from OrderNumber";
            if (tb.length() > 0) {
                    sql += " where id like %'" + tb + "'%";
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<OrderNumber> list = new ArrayList<OrderNumber>();
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                boolean status = rs.getBoolean("status");
                OrderNumber tc = new OrderNumber(id, status);
                list.add(tc);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<OrderNumber> findbystatus(boolean status) {
        try {
            String sql = "select * from OrderNumber";
            if (status) {
                    sql += " where status = 1";
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<OrderNumber> list = new ArrayList<OrderNumber>();
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                boolean Status = rs.getBoolean("status");
                OrderNumber tc = new OrderNumber(id, Status);
                list.add(tc);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
