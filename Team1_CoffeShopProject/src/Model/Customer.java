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
public class Customer {
    private String phone;
    private String name;
    private int point;

    public Customer() {
    }

    public Customer(String phone, String name, int point) {
        this.phone = phone;
        this.name = name;
        this.point = point;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
}
