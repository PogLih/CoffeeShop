/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.Storage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh
 */
public class StorageDAO {

    public void insert(int iddrnk,int quantity) {
        try {
            String sql = "INSERT INTO Storage (iddrink,quantity) VALUES (?, ?)";
            JdbcHelper.executeUpdate(sql,
                    iddrnk,
                    quantity);
        } catch (Exception e) {
            System.out.println("Loi insert");
        }
    }

    public void update(Storage model) {
        try {
            String sql = "UPDATE Storage SET quantity=? WHERE iddrink=?";
            JdbcHelper.executeUpdate(sql,
                     model.getQuantity(),model.getId());
        } catch (Exception e) {
            System.out.println("Loi update");
        }
    }

    public void delete(String iddrink) {
        try {
            String sql = "DELETE FROM Storage WHERE iddrink=?";
            JdbcHelper.executeUpdate(sql, iddrink);
        } catch (Exception e) {
            System.out.println("Loi xoas");
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
 public boolean check(int id)
    {
        String sql="select * from Storage where iddrink like ?";
        ResultSet rs = JdbcHelper.executeQuery(sql, id);
        try
        {
          if(rs.next())
          {
              return true;
          }
        }
        catch(Exception e)
        {
            System.out.println("e");
        }
        return false;
    }
    public List<Storage> findbyid(int id) {
        try {
            String sql = "select * from Storage";
            if (id > 0) {
                sql += " where iddrink like " + id;
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Storage> list = new ArrayList<Storage>();
            while (rs.next()) {

                Integer iddrink = Integer.parseInt(rs.getString("iddrink"));
                Integer quantity = Integer.parseInt(rs.getString("quantity"));
                Storage ac = new Storage(iddrink, quantity);
                list.add(ac);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static boolean isNumberic(String strnumb) {
        if (strnumb == null) {
            return false;
        }
        try {
            float d = Float.parseFloat(strnumb);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str.equals("")) {
            return false;
        }
        return true;
    }
}
