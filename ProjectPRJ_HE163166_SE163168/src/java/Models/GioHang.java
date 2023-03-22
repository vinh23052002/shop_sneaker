/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author asus
 */
public class GioHang {
    private String User;
    private int Pid;
    private String Pname;
    private int Pprice; 
    private String Pimage;
    private int Quantity;
    private boolean isChose;
    public GioHang() {
    }

    public GioHang(String User, int Pid, String Pname, int Pprice, String Pimage, int Quantity, boolean isChose) {
        this.User = User;
        this.Pid = Pid;
        this.Pname = Pname;
        this.Pprice = Pprice;
        this.Pimage = Pimage;
        this.Quantity = Quantity;
        this.isChose = isChose;
    }

    

    

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    
    public int getPid() {
        return Pid;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public int getPprice() {
        return Pprice;
    }

    public void setPprice(int Pprice) {
        this.Pprice = Pprice;
    }

    public String getPimage() {
        return Pimage;
    }

    public void setPimage(String Pimage) {
        this.Pimage = Pimage;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public boolean isIsChose() {
        return isChose;
    }

    public void setIsChose(boolean isChose) {
        this.isChose = isChose;
    }

    @Override
    public String toString() {
        return "GioHang{" + "User=" + User + ", Pid=" + Pid + ", Pname=" + Pname + ", Pprice=" + Pprice + ", Pimage=" + Pimage + ", Quantity=" + Quantity + ", isChose=" + isChose + '}';
    }

    
  
    
}
