package com.shopping.api.domain.orders;

import com.shopping.api.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "Posts_id")
    private Long postsid; //상품id번호

    //주문자-Id번호
    //@ManyToOne
    //@JoinColumn(name = "Member_id")
    private Long memberid;

    //결제일
    private Date orderdate;

    //결제수단
    private String payment;

    //최종 결제된 가격
    private Long pay_amount;

    //상품테이블에서 할인된 가격 연결
    //@ManyToOne
    //@JoinColumn(name = "Posts_price0")
    private Long price0;

    //상품테이블에서 상품id에서 결제당시 shipping_price가격 기입입
    //@ManyToOne
    //@JoinColumn(name = "Posts_shippingprice")
    private Long shippingprice;

    //주소지0
    private String address0;

    //주소지1
    private String address1;

    //우편번호
    private int addressnum;

    //전화번호
    private String phonenum;

    //택배 송장
    private Long shippingnum;

    //택배회사
    private String shipname;

    @Builder
    public Orders(Long postsid,Long memberid,Date orderdate, String payment,Long pay_amount, String address0, String address1, int addressnum,String phonenum,Long shippingnum,String shipname){
        this.postsid=postsid;
        this.memberid=memberid;
        this.orderdate = orderdate;
        this.payment = payment;
        this.pay_amount = pay_amount;
        this.address0 = address0;
        this.address1 = address1;
        this.addressnum = addressnum;
        this.phonenum = phonenum;
        this.shippingnum = shippingnum;
        this.shipname = shipname;
    }

    //유저가 수정
    public  void userupdate(String address0, String address1, int addressnum,String phonenum){
        this.address0 = address0;
        this.address1 = address1;
        this.addressnum = addressnum;
        this.phonenum = phonenum;
    }

    //관리자,판매자 수정가능
    public  void Update(String address0, String address1, int addressnum,String phonenum,Long shippingnum,String shipname){
        this.address0 = address0;
        this.address1 = address1;
        this.addressnum = addressnum;
        this.phonenum = phonenum;
        this.shippingnum = shippingnum;
        this.shipname = shipname;
    }
}
