package com.lab.jpa.groupbuy.repository;

import com.lab.jpa.groupbuy.entities.Categories;
import com.lab.jpa.groupbuy.entities.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CategoriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session = null;

    private Session getSession() {
        session = sessionFactory.getCurrentSession();
        return session;
    }

    // 查詢所有商品分類表
    public List queryAllCategories() {
        List list = getSession().createQuery("from Categories c").list();
        return list;
    }

    // 查詢單筆商品分類表
    public Categories getCategories(Integer id) {
        Categories categories = (Categories) getSession().get(Categories.class, id);
        return categories;
    }

    // 新增商品分類表
    public void saveCategories(Categories categories) {
        getSession().persist(categories);
    }

    // 修改商品分類表
    public void updateCategories(Categories categories) {
        getSession().merge(categories);
    }

    // 刪除商品分類表
    public void deleteCategories(Integer id) {
        Categories categories = (Categories) getSession().get(Categories.class, id);
        getSession().delete(categories);
    }


}
