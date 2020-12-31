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
@Table(name = "productForm")
public class ProductForm {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    
    @OneToMany(mappedBy = "productForm",fetch = FetchType.EAGER)
    private Set<ProductItem> productItems=new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(Set<ProductItem> productItems) {
        this.productItems = productItems;
    }

    
    @Override
    public String toString() {
        return "ProductForm{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
