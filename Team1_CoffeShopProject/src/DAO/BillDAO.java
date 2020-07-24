/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;

import Model.Bill;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Minh
 */
public class BillDAO {

    public void insert(int ordernumber, String staffname, String customerphone, float totalprice) {
        try {
            String sql = "insert into Bill(OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values (?,?,?,?)";
            JdbcHelper.executeUpdate(sql,
                    ordernumber,
                    staffname,
                    customerphone,
                    totalprice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Bill model) {
        try {
            String sql = "UPDATE Bill SET Staffname=?,CustomerPhoneNumber=?, TotalPrice=? WHERE id=?";
            JdbcHelper.executeUpdate(sql,
                    model.getStaffname(),
                    model.getCustomerPhoneNumber(),
                    model.getTotalprice(),
                    model.getId());
        } catch (Exception e) {
            System.out.println("Loi update");
        }
    }

    public void delete(String id) {
        try {
            String sql = "DELETE FROM Bill WHERE id=?";
            JdbcHelper.executeUpdate(sql, id);
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

    public int maxbill() {
        try {
            String sql = "select max(id) as id from Bill";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Integer> list = new ArrayList<>();
            while(rs.next()){
                int a = rs.getInt("id");
                list.add(a);
            }
            int a= list.get(0).intValue();
            return a;
        } catch (Exception e) {
            return 0;
        }
    }
    public List<Bill> findbydate(String min,String max) {
        try {
            String sql = "select * from bill where DateCheckIn >= '"+min+"' and DateCheckIn <= '"+max+"'";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Bill> list = new ArrayList<Bill>();
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                Date dateCheckIn = rs.getDate("DateCheckIn");
                int Ordernumber = rs.getInt("OrderNumber");
                String Staffname = rs.getString("Staffname");
                String CustomerPhoneNumber = rs.getString("CustomerPhoneNumber");
                Float TotalPrice = rs.getFloat("TotalPrice");
                Bill tc = new Bill(id, dateCheckIn, Ordernumber, Staffname, CustomerPhoneNumber, TotalPrice);
                list.add(tc);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Bill> findbyid(int bi) {
        try {
            String sql = "select * from Bill";
            if (bi > 0) {;
                
                    sql += " where id like " + bi + "";
                
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Bill> list = new ArrayList<Bill>();
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                Date dateCheckIn = rs.getDate("DateCheckIn");
                int Ordernumber = rs.getInt("OrderNumber");
                String Staffname = rs.getString("Staffname");
                String CustomerPhoneNumber = rs.getString("CustomerPhoneNumber");
                Float TotalPrice = rs.getFloat("TotalPrice");
                Bill tc = new Bill(id, dateCheckIn, Ordernumber, Staffname, CustomerPhoneNumber, TotalPrice);
                list.add(tc);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public int maxbill(int order) {
        try {
            String sql = "select max(id) as id from Bill";
            if(order>0)
                sql+=" where OrderNumber="+order;
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Integer> list = new ArrayList<>();
            while(rs.next()){
                int a = rs.getInt("id");
                list.add(a);
            }
            int a= list.get(0).intValue();
            return a;
        } catch (Exception e) {
            return 0;
        }
    }

}
