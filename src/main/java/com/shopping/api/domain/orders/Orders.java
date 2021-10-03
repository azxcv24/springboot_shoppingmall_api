package com.shopping.api.domain.orders;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postsid; //상품id번호

    //주문자이메일

    //주소지

    //전화번호

    //결제 정보
}
