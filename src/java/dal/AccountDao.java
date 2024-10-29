/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;

// Vì class này thực hiện thao tác trên database => Ta phải có 1 cái connections => kết nối đến database
import java.util.*;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// UserDAO => Đã có connections
public class AccountDao extends DBConnect {

    private Connection c = null;
    private PreparedStatement SQLQuery = null;
    private ResultSet rs = null;
    // Method : Đọc dữ liệu có trong bảng Users từ database lên Java
    
    public List<Account> getUser() {
        List<Account> list = new ArrayList<Account>();
        String query = "select * from Account";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                account.setEmail(rs.getString("email"));
                account.setPhone_number(rs.getString("phone_number"));
                list.add(account);
            }
        } catch (Exception e) {

        }
        return list;
    }
// u id: 10, name = Vipqua , gmail: abc@gmail.com
    public void addUsers(Account u) {
        String query = "INSERT INTO [dbo].[Account] ([username],[password]) VALUES (?,?)";
        try{
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setString(1, u.getUsername());
            SQLQuery.setString(2, u.getPassword());
            
            SQLQuery.executeUpdate();
        }catch(Exception e){
        }
    }
    public void addUser(String username, String password,  String phone, String email,String role) {
        String query = "insert into Account values (?, ?, ?, ?,?)";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setString(1, username);
            SQLQuery.setString(2, password);
            SQLQuery.setString(3, phone);
            SQLQuery.setString(4, email);
            SQLQuery.setString(5, role);
            SQLQuery.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Account login(String username, String password) {

        try {
            c = makeConnection();
            if (c != null) {
                String sql = "select * from Account where username=? and password=?";
                SQLQuery = c.prepareStatement(sql);
                SQLQuery.setString(1, username);
                SQLQuery.setString(2, password);
                rs = SQLQuery.executeQuery();
                if (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setUsername(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setPassword(rs.getString("email"));
                    account.setPhone_number(rs.getString("phone_number"));
                    account.setRole(rs.getString("role"));                    
                    return account;
                }
            }
        } catch (Exception e) {

        }
        return null;
    }
       
    public boolean getUser(String username){
        String query = "select * from Account where username = ?";
        
        try {
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setString(1, username);
            rs = SQLQuery.executeQuery();
            if(rs.next() == true){
                return true;
            }
        } catch (Exception e) {
        }
        return false; 
    }
    
    public void deleteAccount(int id) {
        String query = "DELETE FROM Account WHERE id = ?";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setInt(1, id);
            SQLQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
        
    public void setNewPassword(int accId, String password) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET \n"
                + "      [password] = ? \n"
                + "\n"
                + " WHERE [dbo].[Account].id=?";
        try {
            SQLQuery = c.prepareStatement(sql);
            SQLQuery.setString(1, password);
            SQLQuery.setInt(2, accId);
            SQLQuery.executeUpdate();
        } catch (Exception e) {
        }

    }
    public void UpdateUser(String role, String accountID, String username, String password, String email, String phone_number) {
    String query = "UPDATE Account SET role = ?, username = ?, password = ?, email = ?, phone_number = ? WHERE id = ?";
    try {
        c = makeConnection();
        SQLQuery = c.prepareStatement(query);
        
        // Set parameters
        SQLQuery.setString(1, role);
        SQLQuery.setString(2, username);
        SQLQuery.setString(3, password);
        SQLQuery.setString(4, email);
        SQLQuery.setString(5, phone_number);
        SQLQuery.setString(6, accountID);
        
        // Execute update
        SQLQuery.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging
    } finally {
        // Ensure resources are closed
        try {
            if (SQLQuery != null) SQLQuery.close();
            if (c != null) c.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log any exceptions during resource cleanup
        }
    }
}
    public void UpdateUser(int accountID, String username, String password, String email, String phone_number) {
    String query = "UPDATE Account SET username = ?, password = ?, email = ?, phone_number = ? WHERE id = ?";
    Connection c = null;
    PreparedStatement SQLQuery = null;

    try {
        c = makeConnection();
        SQLQuery = c.prepareStatement(query);
        
        // Set parameters
        SQLQuery.setString(1, username);
        SQLQuery.setString(2, password);
        SQLQuery.setString(3, email);
        SQLQuery.setString(4, phone_number);
        SQLQuery.setInt(5, accountID);
        
        // Execute update
        SQLQuery.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging
    } finally {
        // Ensure resources are closed
        try {
            if (SQLQuery != null) SQLQuery.close();
            if (c != null) c.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log any exceptions during resource cleanup
        }
    }
}
    public Account getUserID(int uID) {
        String query = "select * from Account where id = ?";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setInt(1, uID);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                account.setEmail(rs.getString("email"));
                account.setPhone_number(rs.getString("phone_number"));
                return account;
            }
        } catch (Exception e) {

        }
        return null;
    }
    public static void main(String[] args) {
        AccountDao p = new AccountDao();
        Account a = p.login("thanh", "123");
        
            System.out.println(a);
        
    }
    
}
