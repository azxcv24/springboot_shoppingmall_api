package com.shopping.api.web.dto.orders;

import com.shopping.api.domain.orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class OrdersSaveRequestDto {
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

    @Builder
    public OrdersSaveRequestDto(Long postsid,Long memberid,Date orderdate, String payment,Long pay_amount, String address0, String address1, int addressnum,String phonenum,Long shippingnum,String shipname){
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



    public Orders toEntity(){
        return Orders.builder()
                .postsid(postsid)
                .memberid(memberid)
                .orderdate(orderdate)
                .payment(payment)
                .pay_amount(pay_amount)
                .address0(address0)
                .address1(address1)
                .addressnum(addressnum)
                .phonenum(phonenum)
                .shippingnum(shippingnum)
                .shipname(shipname)
                .build();

    }
}
