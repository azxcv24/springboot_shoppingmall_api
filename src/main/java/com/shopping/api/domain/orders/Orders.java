package com.shopping.api.domain.orders;

import com.shopping.api.domain.member.Member;

import javax.persistence.*;
import java.util.Date;

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long postsid; //상품id번호

    //주문자-Id번호
    @ManyToOne
    @JoinColumn(name = "Member_id")
    private long memberid;

    //결제일
    private Date orderdate;

    //결제수단
    private String payment;

    //최종 결제된 가격
    private long pay_amount;

    //상품테이블에서 할인된 가격 연결
    private long price0;

    //상품테이블에서 상품id에서 결제당시 shipping_price가격 기입입
    private long shippingprice;

    //주소지0
    private String address0;

    //주소지1
    private String address1;

    //우편번호
    private int addressnum;

    //전화번호
    private String phonenum;

    //택배 송장
    private long shippingnum;

    //택배회사
    private String shipname;

}
