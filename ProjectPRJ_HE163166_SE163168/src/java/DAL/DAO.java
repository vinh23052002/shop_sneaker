/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author asus
 */
public class DAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ArrayList<Product> product;
//    private ArrayList<Category> category;
    private HashMap<Integer, Category> category;
    public String status = "";
    private Product OneProduct = null;
    private ArrayList<Account> account;
    private ArrayList<GioHang> giohang;
    private HashMap<Integer, Order> order;
    private ArrayList<OrderDetail> orderDetail;

    public DAO() {
        try {
            con = new DBContext().getConnection();
            status = "Ket noi thanh cong";
        } catch (Exception e) {
            status = "Ket noi that bai" + e.getMessage();
        }
    }

    public HashMap<Integer, Order> getOrder() {
        return order;
    }

    public void setOrder(HashMap<Integer, Order> order) {
        this.order = order;
    }

    public ArrayList<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public ArrayList<GioHang> getGiohang() {
        return giohang;
    }

    public void setGiohang(ArrayList<GioHang> giohang) {
        this.giohang = giohang;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    public HashMap<Integer, Category> getCategory() {
        return category;
    }

    public void setCategory(HashMap<Integer, Category> category) {
        this.category = category;
    }

    public Product getOneProduct() {
        return OneProduct;
    }

    public void setOneProduct(Product OneProduct) {
        this.OneProduct = OneProduct;
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<Account> account) {
        this.account = account;
    }

    public void LoadProduct() {
        String sql = "select * from Product_HE163166_SE1638";
        product = new ArrayList<Product>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                product.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            status = "loi ket noi o Load Product " + e.getMessage();
        }

    }

//    public void LoadCategory() {
//        String sql = "select * from Category_HE163166_SE1638";
//        category = new ArrayList<Category>();
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                category.add(new Category(rs.getInt(1), rs.getString(2)));
//
//            }
//        } catch (Exception e) {
//            status = "loi ket noi o LoadCategory " + e.getMessage();
//        }
//    }
    public void LoadCategory() {
        String sql = "select * from Category_HE163166_SE1638";
        category = new HashMap<Integer, Category>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                category.put(rs.getInt(1), new Category(rs.getInt(1), rs.getString(2)));

            }
        } catch (Exception e) {
            status = "loi ket noi o LoadCategory " + e.getMessage();
        }
    }

    public void LoadProductByCatagoryID(String cid) {
        String sql = "select * from Product_HE163166_SE1638 where cid=?";
        product = new ArrayList<Product>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                product.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            status = "loi ket noi o LoadProductByCatagoryID " + e.getMessage();
        }
    }

    public void LoadOneProduct(String pid) {
        String sql = "select * from Product_HE163166_SE1638 where id=?";
        OneProduct = new Product();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                OneProduct = (new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            status = "loi ket noi o LoadProductByCatagoryID " + e.getMessage();
        }
    }

    public void LoadProduct_Pagination(int pageIndex, int nrpp, ArrayList<Product> list) {
        product = new ArrayList<Product>();
        for (int i = (pageIndex - 1) * nrpp; i < nrpp * pageIndex; i++) {
            if (i < list.size()) {
                product.add(list.get(i));
            }
        }

    }

    public void LoadAccount_Pagination(int pageIndex, int nrpp, ArrayList<Account> list) {
        account = new ArrayList<Account>();
        for (int i = (pageIndex - 1) * nrpp; i < nrpp * pageIndex; i++) {
            if (i < list.size()) {
                account.add(list.get(i));
            }
        }

    }

    public void SearchByName(String txt) {
        String sql = "select* from Product_HE163166_SE1638 \n"
                + "where name like ?";
        product = new ArrayList<Product>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                product.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            status = "loi ket noi o LoadProductByCatagoryID " + e.getMessage();
        }
    }
//    public void SearchByName(String txt) {
//        String sql = "select* from Product_HE163166_SE1638 \n"
//                + "where name like ?";
//        product = new ArrayList<Product>();
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + txt + "%");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                product.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getDouble(3),
//                        rs.getString(4),
//                        rs.getInt(5)));
//            }
//        } catch (Exception e) {
//            status = "loi ket noi o LoadProductByCatagoryID " + e.getMessage();
//        }
//    }

    public Account Login(String userName, String pass) {
        String sql = "select * from Account_HE163166_SE1638 \n"
                + "where UserName= ? and Pass=?";
        pass = encrypt(pass, "123");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkUserExist(String user) {
        String sql = "select * from Account_HE163166_SE1638\n"
                + "where UserName=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkEmailExist(String email) {
        String sql = "select * from Account_HE163166_SE1638\n"
                + "where email=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void SignUp(String user, String pass, String gender, String email, String add, String phone, String roll) {
        String sql = "Insert into Account_HE163166_SE1638\n"
                + "values (?,?,?,?,?,?,?)";
        pass = encrypt(pass, "123");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, add);
            ps.setString(6, phone);
            ps.setString(7, roll);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void LoadAccount() {
        String sql = "select * from Account_HE163166_SE1638";
        account = new ArrayList<Account>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                account.add(new Account(rs.getString(1),
                        decrypt(rs.getString(2), "123"),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
    }

    public void DeleteAccount(String userName) {
        String sql = "delete from Account_HE163166_SE1638\n"
                + "where UserName=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account LoadAccountByUser(String user) {
        String sql = "select * from Account_HE163166_SE1638 where UserName=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        decrypt(rs.getString(2), "123"),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void UpdateAccount(String user, String pass, String gender, String email, String add, String phone, String roll) {
        String sql = "update Account_HE163166_SE1638\n"
                + "set Pass = ?,\n"
                + "	Gender=?,\n"
                + "	email=?,\n"
                + "	[add]=?,\n"
                + "	phone=?,\n"
                + "	roll=?\n"
                + "where UserName=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, encrypt(pass, "123"));
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, add);
            ps.setString(5, phone);
            ps.setString(6, roll);
            ps.setString(7, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddNewProduct(String id, String name, String price, String image, String cid) {
        String sql = "insert into Product_HE163166_SE1638\n"
                + "values(?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setString(5, cid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean CheckIdExist(String id) {
        String sql = "select *from Product_HE163166_SE1638\n"
                + "where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void DeleteProduct(String id) {
        String sql = "delete from Product_HE163166_SE1638\n"
                + "where id=?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void ThemVaoGioHang(String User, String Pid, String Pname, String Pprice, String Pimage, String Quantity) {
        String sql = "Insert into GioHang_HE163166_SE1638\n"
                + "values(?,?,?,?,?,?,0)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Pid);
            ps.setString(3, Pname);
            ps.setString(4, Pprice);
            ps.setString(5, Pimage);
            ps.setString(6, Quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void TangQuantityTrongGioHang(String user, String pid) {
        String sql = "Update GioHang_HE163166_SE1638\n"
                + "set Quantity+=1\n"
                + "where [User] = ? and Pid=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean PidTonTaiChua(String user, String pid) {
        String sql = "select* from GioHang_HE163166_SE1638 where [User]=? and Pid=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void LoadGioHangByUser(String User) {
        String sql = "select* from GioHang_HE163166_SE1638 where [User]= ?";
        giohang = new ArrayList<GioHang>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                giohang.add(new GioHang(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        }
    }

    public void XoaGioHang(String Pid) {
        String sql = "delete from GioHang_HE163166_SE1638\n"
                + "where Pid=? and isChose=1";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UpdateQuantity(String Quantity, String User, String Pid) {
        String sql = "update GioHang_HE163166_SE1638\n"
                + "set Quantity=?\n"
                + "where [User] =? and Pid=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Quantity);
            ps.setString(2, User);
            ps.setString(3, Pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static String getRandom() {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return String.format("%06d", number);
    }

    public void SendMail(String to, String sub, String msg, String user, String pass) {
        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        javax.mail.Session session = javax.mail.Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendEmail(String pin) {
        String subject = "dfdd";
        String message = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>JSP Page</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + pin
                + "    </body>\n"
                + "</html>\n"
                + "";
        SendMail("vinh23052002@gmail.com", subject, message, "vinhnqhe163166@fpt.edu.vn", "vinhvip123");

    }

    public void ChangePassword(String Newpass, String User) {
        String sql = "update Account_HE163166_SE1638\n"
                + "set Pass=?\n"
                + "where UserName=?";
        Newpass = encrypt(Newpass, "123");

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Newpass);
            ps.setString(2, User);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UpdateProduct(String id, String name, String price, String image, String cid) {
        String sql = "update Product_HE163166_SE1638\n"
                + "set [name]=?,price=?,image=?,Cid=?\n"
                + "where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, image);
            ps.setString(4, cid);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int GetLastOrderID() {
        String sql = "select top 1 OrderID from Order_HE163166_SE1638\n"
                + "order by OrderID desc";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void AddOrder(String user) {
        String sql = "insert into Order_HE163166_SE1638 values(?,GETDATE(),?,0)";
        int id = GetLastOrderID();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int GetLastOrderDetailID() {
        String sql = "select top 1 OrderDetailID from OrderDetail_HE163166_SE1638\n"
                + "order by OrderID desc";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void AddOrderDetail(int Pid, int quantity) {
        String sql = "insert into OrderDetail_HE163166_SE1638\n"
                + "values(?,?,?,?)";
        int odID = GetLastOrderDetailID();
        int oId = GetLastOrderID();
        int id = GetLastOrderID();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, odID);
            ps.setInt(2, oId);
            ps.setInt(3, Pid);
            ps.setInt(4, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void LoadOrder() {
        String sql = "select * from Order_HE163166_SE1638";
        order = new HashMap<Integer, Order>();
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                order.put(rs.getInt(1),
                        new Order(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4)));
            }
        } catch (Exception e) {
        }
    }

    public void LoadOrderDetail(int Oid) {
        String sql = "select * from OrderDetail_HE163166_SE1638 where OrderID=?";
        orderDetail = new ArrayList<OrderDetail>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderDetail.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
    }

    public double GetToalByOid(int oid) {
        String sql = "select SUM(od.Quantity*p.price) from OrderDetail_HE163166_SE1638 od \n"
                + "join Order_HE163166_SE1638 o on od.OrderID=o.OrderID\n"
                + "join Product_HE163166_SE1638 p on p.id=od.ProductID\n"
                + "where o.OrderID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void CheckDone(String Oid) {
        String sql = "update Order_HE163166_SE1638\n"
                + "set Status=1\n"
                + "where OrderID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void DeleteOid(String Oid) {
        String sql = "delete Order_HE163166_SE1638\n"
                + "where OrderID=?;\n"
                + "delete OrderDetail_HE163166_SE1638\n"
                + "where OrderID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Oid);
            ps.setString(2, Oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(final String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(final String strToEncrypt, final String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(final String strToDecrypt, final String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder()
                    .decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public void SortDesc() {
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void SortAsc() {
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void ChosePriceProduct(double min, double max) {
        String sql = "select * from Product_HE163166_SE1638\n"
                + "where price>? and price<?";
        product = new ArrayList<Product>();
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            rs = ps.executeQuery();
            while (rs.next()) {
                product.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            status = "loi ket noi o Load Product " + e.getMessage();
        }

    }

    public boolean isChose(String user, String pid) {
        String sql = "select * from GioHang_HE163166_SE1638\n"
                + "where [User]=? and Pid=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getBoolean(7);
            }
        } catch (Exception e) {
            status = "loi ket noi o Load Product " + e.getMessage();
        }
        return false;
    }

    public void ChangeChose(String user, String pid) {
        String sql = "Update GioHang_HE163166_SE1638\n"
                + "set isChose=?\n"
                + "where [User]=? and Pid=?";
        boolean ischose = !isChose(user, pid);
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, ischose);
            ps.setString(2, user);
            ps.setString(3, pid);
            ps.executeUpdate();

        } catch (Exception e) {
            status = "loi ket noi o Load Product " + e.getMessage();
        }

    }

    public ArrayList<GioHang> LoadGioHangChose(String User) {
        String sql = "select* from GioHang_HE163166_SE1638 where [User]= ? and ischose=1";
        ArrayList<GioHang> listChose = new ArrayList<GioHang>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                listChose.add(new GioHang(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        }
        return listChose;
    }

    public void LoadOrderbyDate(String date) {
        String sql = "select * from Order_HE163166_SE1638\n"
                + "where [Date]>? and [Date]<?";
        order = new HashMap<Integer, Order>();
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, date+" 00:00:00.000");
            ps.setString(2, date+" 23:59:59.000");
            rs = ps.executeQuery();
            while (rs.next()) {
                order.put(rs.getInt(1),
                        new Order(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4)));
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.LoadOrderbyDate("2022-11-06");
        System.out.println(dao.getOrder().size());

    }

}
