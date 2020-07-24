/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.Account;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh
 */
public class AccountDAO {

    public void insert(Account model) {
        try {
            String sql = "INSERT INTO Account (Username,DisplayName,PassWord,Type) VALUES (?, ?, ?, ?)";
            JdbcHelper.executeUpdate(sql,
                    model.getUsername(),
                    model.getDisplayName(),
                    model.getPassWord(),
                    model.isRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Account model) {
        try {
            String sql = "UPDATE Account SET PassWord=?, DisplayName=?, Type=? WHERE Username=?";
            JdbcHelper.executeUpdate(sql,
                    model.getPassWord(), model.getDisplayName(), model.isRole(), model.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String Username) {
        try {
            String sql = "DELETE FROM Account WHERE Username=?";
            JdbcHelper.executeUpdate(sql, Username);
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

    public List<Account> ShowAccounts(String username) {
        try {
            String sql = "select * from Account";
            if(username.length()>0){
                sql+= " where Username like '%" + username + "%'";
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Account> list = new ArrayList<Account>();
            while(rs.next()){
                String name = rs.getString(1);
                String display = rs.getString(2);
                String password = rs.getString(3);
                boolean role = rs.getBoolean(4);
                Account ac = new Account(name, display, password, role);
                list.add(ac);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
