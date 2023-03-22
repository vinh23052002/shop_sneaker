/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author asus
 */
public class Category {
    private int Cid;
    private String Cname;

    public Category(int Cid, String Cname) {
        this.Cid = Cid;
        this.Cname = Cname;
    }

    public Category() {
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    @Override
    public String toString() {
        return "Category{" + "Cid=" + Cid + ", Cname=" + Cname + '}';
    }
    
    
}
