package com.lab.jpa.groupbuy.repository;

import com.lab.jpa.groupbuy.entities.Customer;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session = null;

    private Session getSession() {
        session = sessionFactory.getCurrentSession();
        return session;
    }

    // 查詢所有顧客資料
    public List queryAllCustomers() {
        List list = getSession().createQuery("from Customer c").list();
        return list;
    }

    // 查詢單筆顧客
    public Customer getCustomer(Integer id) {
        Customer customer = (Customer) getSession().get(Customer.class, id);
        return customer;
    }

    // 新增顧客
    public void saveCustomer(Customer customer) {
        getSession().persist(customer);
    }

    // 修改顧客
    public void updateCustomer(Customer customer) {
        getSession().merge(customer);
    }

    // 刪除顧客
    public void deleteCustomer(Integer id) {
        Customer customer = (Customer) getSession().get(Customer.class, id);
        getSession().delete(customer);
    }


}
