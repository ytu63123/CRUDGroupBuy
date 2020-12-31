package com.lab.jpa.groupbuy.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productItem")
public class ProductItem {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer cost;

    @Column
    private Integer inventory;

    @Column
    private Integer price;

    @Column
    private Integer shelflife;

    @Column
    private String description;

    @Column
    private String name;
    
    @Column
    private String image;
    
    @OneToMany(mappedBy = "productItem",fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems=new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "productForm_id")
    private ProductForm productForm;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getShelflife() {
        return shelflife;
    }

    public void setShelflife(Integer shelflife) {
        this.shelflife = shelflife;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ProductForm getProductForm() {
        return productForm;
    }

    public void setProductForm(ProductForm productForm) {
        this.productForm = productForm;
    }

    @Override
    public String toString() {
        return "ProductItem{" + "id=" + id + ", cost=" + cost + ", inventory=" + inventory + ", price=" + price + ", shelflife=" + shelflife + ", description=" + description + ", name=" + name + ", image=" + image + '}';
    }
    
    

}
