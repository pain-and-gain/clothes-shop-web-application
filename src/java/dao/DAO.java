/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Account;
import entities.Category;
import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnect;

/**
 *
 * @author ADMIN
 */
public class DAO {

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            if (con != null) {
                String sql = "Select * From product";
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                rs.close();
            }
            if (con != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<Category> getAllCategory() throws SQLException {
        List<Category> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            if (con != null) {
                String sql = "Select * From Category";
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Category c = new Category(rs.getInt(1), rs.getString(2));
                    list.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                rs.close();
            }
            if (con != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<Product> getProductByCid(String cid) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            if (con != null) {
                String sql = "Select * From product Where cateID=?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, cid);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public Product getProductById(int pid) throws SQLException {
        try {
            con = DBConnect.getConnection();
            if (con != null) {
                String sql = "Select * From product Where id=?";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, pid);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
                    return p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                rs.close();
            }
            if (con != null) {
                rs.close();
            }
        }
        return null;
    }

    public List<Product> searchByName(String search) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            if (con != null) {
                String sql = "Select * From product Where name like ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, "%" + search + "%");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                rs.close();
            }
            if (con != null) {
                rs.close();
            }
        }
        return list;
    }

    public Account login(String userID, String pass) throws SQLException {
        try {
            con = DBConnect.getConnection();
            String sql = "Select * from account where uID=? and password=?";
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.setString(2, pass);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Account acc = new Account(rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getInt(4));
                    return acc;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
   
   public Account checkDuplicate(String userID) throws SQLException {
        try {
            con = DBConnect.getConnection();
            String sql = "Select * from account where uID=? ";
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, userID);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Account acc = new Account(rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getInt(4));
                    return acc;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    } 
   
   public void SignUp(String userID, String username,String password) throws SQLException{
       String sql="Insert Into account (uID,userName,password,isAdmin) Values(?,?,?,0)";
       try{
           con=DBConnect.getConnection();
           pstm=con.prepareStatement(sql);
           pstm.setString(1, userID);
           pstm.setString(2, username);
           pstm.setString(3, password);
           pstm.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
   }
   
   public void Delete(int pid) throws SQLException{
       String sql="Delete From product where id=?";
       try{
           con=DBConnect.getConnection();
           pstm=con.prepareStatement(sql);
           pstm.setInt(1,pid);
           pstm.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
   }
   
   public void AddProduct(String name, String image, double price, String title,
  String description,String category ) throws SQLException{
       String sql="Insert Into product(name,image,price,title,description,cateID)"
               + " Values(?,?,?,?,?,?)";
       try{
           con=DBConnect.getConnection();
           pstm=con.prepareStatement(sql);
           pstm.setString(1,name);
           pstm.setString(2,image);
           pstm.setDouble(3,price);
           pstm.setString(4,title);
           pstm.setString(5,description);
           pstm.setString(6,category);
           pstm.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
   }
   
      public void editProduct(String name, String image, double price, String title,
  String description,String category, String pid ) throws SQLException{
       String sql="update product Set name=?, image=?, price=?, title=?, "
               + "description=?, cateID=? Where id=? ";
       try{
           con=DBConnect.getConnection();
           pstm=con.prepareStatement(sql);
           pstm.setString(1,name);
           pstm.setString(2,image);
           pstm.setDouble(3,price);
           pstm.setString(4,title);
           pstm.setString(5,description);
           pstm.setString(6,category);
           pstm.setString(7, pid);
           pstm.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
   }
}
