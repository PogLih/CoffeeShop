/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Helper.JdbcHelper;
import Model.Category;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Linh
 */
public class CategoryDAO {
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
    public List<Category> ShowCate(String namecategory){
        try {
            String sql = "select * from Category";
            if(namecategory.length()>0){
                if(IsNumber(namecategory)==true) sql+=" where id like '%"+namecategory+"%'";
                else
                sql+= " where name like '%"+namecategory+"%'";
            }
            ResultSet rs = JdbcHelper.executeQuery(sql);
            List<Category> list = new ArrayList<Category>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category ctg = new Category(id, name);
                list.add(ctg);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void Insert(String model){
        try {
            String sql="Insert dbo.Category values (?)";
            JdbcHelper.executeUpdate(sql, model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Delete(int model){
        try {
            String SQL ="delete from drinks where idcategory = ?";
            JdbcHelper.executeUpdate(SQL, model);
            String sql="Delete from dbo.Category where id = ?";
            JdbcHelper.executeUpdate(sql, model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Update(Category model){
        try {
            String sql="Update dbo.Category set name = ? where id = ?";
            JdbcHelper.executeUpdate(sql, model.getName(),model.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
