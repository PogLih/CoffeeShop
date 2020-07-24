/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Minh
 */
public class Bill {
    private int id;
    private Date DateCheckIn;
    private int Ordernumber;
    private String Staffname;
    private String CustomerPhoneNumber;
    private Float totalprice;

    public Bill(int id, Date DateCheckIn, int Ordernumber, String Staffname, String CustomerPhoneNumber, Float totalprice) {
        this.id = id;
        this.DateCheckIn = DateCheckIn;
        this.Ordernumber = Ordernumber;
        this.Staffname = Staffname;
        this.CustomerPhoneNumber = CustomerPhoneNumber;
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCheckIn() {
        return DateCheckIn;
    }

    public void setDateCheckIn(Date DateCheckIn) {
        this.DateCheckIn = DateCheckIn;
    }

    public int getOrdernumber() {
        return Ordernumber;
    }

    public void setOrdernumber(int Ordernumber) {
        this.Ordernumber = Ordernumber;
    }

    public String getStaffname() {
        return Staffname;
    }

    public void setStaffname(String Staffname) {
        this.Staffname = Staffname;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String CustomerPhoneNumber) {
        this.CustomerPhoneNumber = CustomerPhoneNumber;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }    
}
