/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Order {
    private int OrderID;
    private String Date;
    private String User;
    private int Status;

    public Order() {
    }

    public Order(int OrderID, String Date, String User, int Status) {
        this.OrderID = OrderID;
        this.Date = Date;
        this.User = User;
        this.Status = Status;
    }

  

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }


    

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }


    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", Date=" + Date + ", User=" + User + ", Status=" + Status + '}';
    }

   
    
    
}
