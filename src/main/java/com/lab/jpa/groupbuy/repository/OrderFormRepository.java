package com.lab.jpa.groupbuy.repository;

//package com.spring.mvc.groupbuy.repository;
//
//import com.spring.mvc.groupbuy.entities.OrderForm;
//import java.util.Date;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface OrderFormRepository extends JpaRepository<OrderForm, Integer> {
//
//
//    // where id in (?,?,?) OR birth < ?
//    //WHERE id in (2,4,8,16...) OR birth <='2000/12/31'
//    List<OrderForm> getByIdInOrdateLessThanEqual(List<Integer> ids, Date date);
//
//    //查詢User+age<?(但是age並不是User的屬性)
//    @Query("SELECT o FROM OrderForm o WHERE (YEAR(current_date)-YEAR(u.date))< :time")
//    List<OrderForm> getByTimeLessThan(Integer time);
//
//    //查詢資料筆數
//    @Query(value = "SELECT count(id) FROM orderForm", nativeQuery = true)
//    Long getTotalCount();
//
//}
