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
public class BillInfo {
    private int idBill;
    private int idDrinks;
    private int quantity;
    private float Price;

    public BillInfo(int idBill, int idDrinks, int quantity, float Price) {
        this.idBill = idBill;
        this.idDrinks = idDrinks;
        this.quantity = quantity;
        this.Price = Price;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdDrinks() {
        return idDrinks;
    }

    public void setIdDrinks(int idDrinks) {
        this.idDrinks = idDrinks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
   
}
