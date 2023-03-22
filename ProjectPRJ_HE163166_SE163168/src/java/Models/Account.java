/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author asus
 */
public class Account {
    
    private String UserName;
    private String Pass;
    private int Gender;
    private String email;
    private String add;
    private String phone;
    private int roll;
    
    public Account() {
    }

    public Account(String UserName, String Pass, int Gender, String email, String add, String phone, int roll) {
        this.UserName = UserName;
        this.Pass = Pass;
        this.Gender = Gender;
        this.email = email;
        this.add = add;
        this.phone = phone;
        this.roll = roll;
    }

    
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    
   
    public String getUserName(){
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    @Override
    public String toString() {
        return "Account{" + "UserName=" + UserName + ", Pass=" + Pass + ", Gender=" + Gender + ", email=" + email + ", add=" + add + ", phone=" + phone + ", roll=" + roll + '}';
    }

    

  
    
    
}
