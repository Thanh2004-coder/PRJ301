/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static dal.DBConnect.makeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CafeItem;
import model.Cart;
import model.Category;

/**
 *
 * @author Helios 16
 */
public class CartDao extends DBConnect{
    private Connection c = null;
    private PreparedStatement SQLQuery = null;
    private ResultSet rs = null;
    public List<Cart> getCart(int cid) {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT * FROM Cart where accountID = ?";
        try {
            c = makeConnection();
            SQLQuery = c.prepareStatement(sql);
            SQLQuery.setInt(1, cid);
            ResultSet rs = SQLQuery.executeQuery();
            while (rs.next()) {
                CafeItemDao cd = new CafeItemDao();
                CafeItem d = cd.getCafeItemById(rs.getString("id"));
                Cart p = new Cart(
                        rs.getInt("quantity"),
                        d.getName(),
                        d.getPrice(),
                        d.getImage());
                list.add(p);
            }
        } catch (Exception ex) {
        }
        return list;
    }
    public static void main(String[] args) {
        CartDao p = new CartDao();
        List<Cart> a = p.getCart(4);
        for(Cart c : a){
            System.out.println(c.toString());
        }
    }
    
}
