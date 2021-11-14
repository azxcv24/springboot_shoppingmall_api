package com.shopping.api.domain.orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


    //주문자 주문검색
    @Query("SELECT o " +"FROM Orders o WHERE o.postsid = COALESCE(:postsid, o.postsid) AND o.memberid = COALESCE(:memberid, o.memberid)" +
            " AND o.orderdate = COALESCE(:orderdate, o.orderdate)" +
            " ORDER BY o.id DESC")
    Page<Orders> findAllOrdersWithPagination(Long postsid, Long memberid, Date orderdate, Pageable pageable);


    //관리자 주문 전체체
    @Query("SELECT o FROM Orders o ORDER BY o.id DESC")
    List<Orders> findAllDesc();
}
