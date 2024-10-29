/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CafeItem;
import model.Category;

public class CafeItemDao extends DBConnect {

    private Connection c = null;
    private PreparedStatement SQLQuery = null;
    private ResultSet rs = null;

    public List<CafeItem> readListCafe() {
        List<CafeItem> list = new ArrayList<>();
        String query = "SELECT * FROM CafeItem";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query); ResultSet rs = SQLQuery.executeQuery()) {

            while (rs.next()) {
                CafeItem p = new CafeItem();
                p.setId(rs.getString("id")); // Change to int
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity")); // Change to int
                p.setPrice(rs.getInt("price")); // Change to int
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
        return list;
    }

    public List<CafeItem> pagingCafeItem(int index) {
        List<CafeItem> list = new ArrayList<CafeItem>();
        String query = "select * from CafeItem ORDER BY id OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setInt(1, (index - 1) * 6);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                CafeItem p = new CafeItem();
                p.setId(rs.getString("id")); // Change to int
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity")); // Change to int
                p.setPrice(rs.getInt("price")); // Change to int
                p.setImage(rs.getString("image"));
                list.add(p);
            }
            System.out.println(list);
        } catch (Exception e) {
        }
        return list;
    }

    public int getTotalCafeItem() {
        String query = "select count(*) from CafeItem";
        try {
            // Open the database connection
            c = makeConnection();
            SQLQuery = c.prepareStatement(query);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }

        } catch (Exception ex) {
        }
        return 0;
    }

    public List<CafeItem> read4TopCafe() {
        List<CafeItem> list = new ArrayList<>();
        String query = "SELECT TOP 4 * FROM CafeItem";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query); ResultSet rs = SQLQuery.executeQuery()) {

            while (rs.next()) {
                CafeItem p = new CafeItem();
                p.setId(rs.getString("id")); // Change to int
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity")); // Change to int
                p.setPrice(rs.getInt("price")); // Change to int
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
        return list;
    }

    public void addCafeItem(String name, int quantity, int price, String image) {
        String query = "INSERT INTO CafeItem (name, quantity, price, image) VALUES (?, ?, ?, ?)";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query)) {

            SQLQuery.setString(1, name);
            SQLQuery.setInt(2, quantity); // Use int
            SQLQuery.setInt(3, price); // Use int
            SQLQuery.setString(4, image);
            SQLQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

    public void deleteCafeItem(String id) {
        String query = "DELETE FROM CafeItem WHERE id = ?";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query)) {

            SQLQuery.setString(1, id);
            SQLQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

    public List<CafeItem> searchByName(String txtSearch) {
        List<CafeItem> list = new ArrayList<>();
        String query = "select * from CafeItem\n"
                + "where name like ?";
        try {
            c = makeConnection();//mo ket noi voi sql
            SQLQuery = c.prepareStatement(query);
            SQLQuery.setString(1, "%" + txtSearch + "%");
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                list.add(new CafeItem(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

   
    public CafeItem getCafeItemById(String id) {
        String query = "SELECT * FROM CafeItem WHERE id = ?";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query)) {

            SQLQuery.setString(1, id);
            try (ResultSet rs = SQLQuery.executeQuery()) {
                if (rs.next()) {
                    CafeItem product = new CafeItem();
                    product.setId(rs.getString("id")); // Change to int
                    product.setName(rs.getString("name"));
                    product.setQuantity(rs.getInt("quantity")); // Change to int
                    product.setPrice(rs.getInt("price")); // Change to int
                    product.setImage(rs.getString("image"));
                    return product;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
        return null;
    }

    public void updateProduct(String id, String name, int quantity, int price, String image) {
        String query = "UPDATE CafeItem SET name = ?, quantity = ?, price = ?, image = ? WHERE id = ?";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(query)) {

            SQLQuery.setString(1, name);
            SQLQuery.setInt(2, quantity); // Use int
            SQLQuery.setInt(3, price); // Use int
            SQLQuery.setString(4, image);
            SQLQuery.setString(5, id); // Set the ID
            SQLQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

    public List<CafeItem> getProductsByCategoryid(int cid) {
        List<CafeItem> list = new ArrayList<>();
        String sql = "SELECT * FROM CafeItem where categoryID = ?";
        try (Connection c = makeConnection(); PreparedStatement SQLQuery = c.prepareStatement(sql)) {

            SQLQuery.setInt(1, cid);
            rs = SQLQuery.executeQuery();
            while (rs.next()) {
                CategoryDao cd = new CategoryDao();
                Category d = cd.getCategoryById(rs.getInt("categoryID"));
                CafeItem p = new CafeItem(
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getInt("price"),
                        rs.getString("image"),
                        rs.getString("id"),
                        d);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
        return list;
    }

    public static void main(String[] args) {
        CafeItemDao p = new CafeItemDao();
        // Example of adding a new cafe item
//        List<CafeItem> a = p.getProductInCart(2);
//        for (CafeItem product : a) {
//            System.out.println(product.toString());
//        }
//        int a = p.getTotalCafeItem();
//        System.out.println(a);
    }
}
