package model;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.CafeItem;


/**
 *
 * @author lvhho
 */
public class Cart {
    int cartID;
    int accountID;
    CafeItem itemID;
    int quantity;
    String CafeItemName;
    int CafeItemPrice;
    String CafeItemImage; 

    public Cart(int quantity, String CafeItemName, int CafeItemPrice, String CafeItemImage) {
        this.quantity = quantity;
        this.CafeItemName = CafeItemName;
        this.CafeItemPrice = CafeItemPrice;
        this.CafeItemImage = CafeItemImage;
    }

    public Cart(int cartID, int accountID, CafeItem itemID, int quantity) {
        this.cartID = cartID;
        this.accountID = accountID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public int getCartID() {
        return cartID;
    }

    public int getAccountID() {
        return accountID;
    }

    public CafeItem getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setItemID(CafeItem itemID) {
        this.itemID = itemID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCafeItemName() {
        return CafeItemName;
    }

    public int getCafeItemPrice() {
        return CafeItemPrice;
    }

    public String getCafeItemImage() {
        return CafeItemImage;
    }

    public void setCafeItemName(String CafeItemName) {
        this.CafeItemName = CafeItemName;
    }

    public void setCafeItemPrice(int CafeItemPrice) {
        this.CafeItemPrice = CafeItemPrice;
    }

    public void setCafeItemImage(String CafeItemImage) {
        this.CafeItemImage = CafeItemImage;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartID=" + cartID + ", accountID=" + accountID + ", itemID=" + itemID + ", quantity=" + quantity + ", CafeItemName=" + CafeItemName + ", CafeItemPrice=" + CafeItemPrice + ", CafeItemImage=" + CafeItemImage + '}';
    }

    
    

}

