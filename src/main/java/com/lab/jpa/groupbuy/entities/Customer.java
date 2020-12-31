package com.lab.jpa.groupbuy.entities;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Temporal(TemporalType.DATE)
    private Date createDate;
    

    
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<OrderForm> orderForms= new LinkedHashSet<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<OrderForm> getOrderForms() {
        return orderForms;
    }

    public void setOrderForms(Set<OrderForm> orderForms) {
        this.orderForms = orderForms;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", createDate=" + createDate + '}';
    }




                
}
