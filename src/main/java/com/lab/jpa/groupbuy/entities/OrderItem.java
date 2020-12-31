package com.lab.jpa.groupbuy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderItem")
public class OrderItem {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer price;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orderForm_id")
    private OrderForm orderForm;

    @ManyToOne
    @JoinColumn(name = "productItem_id")
    private ProductItem productItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    
    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", price=" + price + ", quantity=" + quantity + '}';
    }

}
