/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Helios 16
 */
public class CategoryDao extends DBConnect {
    private Connection c = null;
    private PreparedStatement SQLQuery = null;
    private ResultSet rs = null;
    public List<Category> getCategory() {
        List<Category> list = new ArrayList<Category>();
        String query = "select * from Category";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                Category product = new Category();
                product.setCategoryID(rs.getInt("categoryID"));
                product.setCategoryName(rs.getString("categoryName"));
                list.add(product);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Category where categoryID=?";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(sql);
            //set ?
            SQLQuery.setInt(1, id);
             rs = SQLQuery.executeQuery();
            //1
            if (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("categoryID"));
                c.setCategoryName(rs.getString("categoryName"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
        return null;
    }
    public String getCategoryNameById(int id) {
    String sql = "SELECT categoryName FROM Category WHERE categoryID=?";
    String categoryName = null; // Khởi tạo biến categoryName

    try {
        c = makeConnection();
        PreparedStatement SQLQuery = c.prepareStatement(sql);
        // Set ?
        SQLQuery.setInt(1, id);
        ResultSet rs = SQLQuery.executeQuery();

        // Kiểm tra kết quả
        if (rs.next()) {
            categoryName = rs.getString("categoryName"); 
            return categoryName;// Lấy categoryName
        }
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception
    } 
    return null; // Trả về categoryName
}
    public static void main(String[] args) {
        CategoryDao p = new CategoryDao();
//        List<Category> a = p.getCategory();
//        for(Category c : a){
//            System.out.println(c.toString());
//        }
//        Category a = p.getCategoryById(4);
//        System.out.println(a);
        String b = p.getCategoryNameById(4);
        System.out.println(b);
    } 
}
