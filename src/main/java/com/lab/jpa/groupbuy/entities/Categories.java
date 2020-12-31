package com.lab.jpa.groupbuy.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    
    @OneToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private Set<ProductForm> productForms=new LinkedHashSet<>();

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

    public Set<ProductForm> getProductForms() {
        return productForms;
    }

    public void setProductForms(Set<ProductForm> productForms) {
        this.productForms = productForms;
    }

    
    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", name=" + name + '}';
    }
    
}
