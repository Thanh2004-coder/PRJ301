/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NCPC
 */
public class CafeItem {
    String name;
    int quantity,price;
    String image;
    String id;
    Category category;
    public CafeItem(String name, int quantity, int price, String image) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.image = image;
        }

    public CafeItem(String name, int quantity, int price, String image, String id, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.id = id;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getImage() {
        return image;
    }

    public CafeItem() {
    }

    public CafeItem(String name, int quantity, int price, String image, String id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CafeItem{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + ", image=" + image + ", id=" + id + ", category=" + category + '}';
    }

    
    
}
