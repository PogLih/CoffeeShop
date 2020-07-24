/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Minh
 */
public class Drinks {
    private int id;
    private String name;
    private int idcategory;
    private float price;
    private String images;

    public Drinks() {
    }

    public Drinks(int id, String name, int idcategory, float price) {
        this.id = id;
        this.name = name;
        this.idcategory = idcategory;
        this.price = price;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public float getPrice() {
        return price;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
    
}
