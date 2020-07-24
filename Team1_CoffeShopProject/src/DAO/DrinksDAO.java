/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Helper.JdbcHelper;
import Model.Drinks;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Minh
 */
public class DrinksDAO {
    public boolean isNumber(String num){
        if(num == null) return false;
        try {
            int n = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public boolean check(String ten) {
        String sql = "select * from Drinks where name like ?";
        ResultSet rs = JdbcHelper.executeQuery(sql, ten);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi");
        }
        return false;

         
    }
    public List<Drinks> ShowDrinks(String namedrink){
        try {
            String sql = "select * from drinks";
            if(namedrink.length()>0){
                if(isNumber(namedrink)==true){
                    sql+= " where id = "+Integer.parseInt(namedrink)+"";
                }
                else{
                sql+= " where name like '%"+namedrink+"%'";
                }
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Drinks> list = new ArrayList<Drinks>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int category = rs.getInt("idcategory");
                float price = rs.getFloat("price");
                
                Drinks dr = new Drinks(id, name, category, price);
                list.add(dr);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Drinks> ShowbyCate(int idcate){
        try {
            String sql = "select * from drinks where idcategory ="+idcate;
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Drinks> list = new ArrayList<Drinks>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int category = rs.getInt("idcategory");
                float price = rs.getFloat("price");
                
                Drinks dr = new Drinks(id, name, category, price);
                list.add(dr);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(String name,int cate,float price) {
        try {
            String sql = "insert into drinks(name,idcategory,price) values (?,?,?)";
            JdbcHelper.executeUpdate(sql,
                    name,
                    cate,
                    price
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Drinks model) {
        try {
            String sql = "UPDATE Drinks SET name=?, idcategory=?, price=? WHERE id=?";
            JdbcHelper.executeUpdate(sql,
                    model.getName(),
                    model.getIdcategory(),
                    model.getPrice(),
                    
                    model.getId());
        } catch (Exception e) {
//            System.out.println("Loi update");
e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM Drinks WHERE id=?";
            JdbcHelper.executeUpdate(sql, id);
        } catch (Exception e) {
            System.out.println("Loi xóa");
        }
    }
}
