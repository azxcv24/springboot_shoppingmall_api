package com.shopping.api.web.dto.orders;

import com.shopping.api.domain.orders.Orders;
import lombok.Getter;

import java.util.Date;

@Getter
public class OrdersResponseDto {

    private Long id;
    private Long postsid;
    private Long memberid;
    private Date orderdate;
    private String payment;
    private Long pay_amount;
    private String address0;
    private String address1;
    private int addressnum;
    private String phonenum;
    private Long shippingnum;
    private String shipname;



    public OrdersResponseDto(Orders entity){
        this.id = entity.getId();
        this.postsid = entity.getPostsid();
        this.memberid = entity.getMemberid();
        this.orderdate = entity.getOrderdate();
        this.payment = entity.getPayment();
        this.pay_amount = entity.getPay_amount();
        this.address0 = entity.getAddress0();
        this.address1 = entity.getAddress1();
        this.addressnum = entity.getAddressnum();
        this.phonenum = entity.getPhonenum();
        this.shippingnum = entity.getShippingnum();
        this.shipname = entity.getShipname();
    }
}
