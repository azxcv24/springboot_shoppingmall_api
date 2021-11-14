package com.shopping.api.web.dto.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersUpdateRequestDto {
    private String address0;
    private String address1;
    private int addressnum;
    private String phonenum;
    private Long shippingnum;
    private String shipname;

    @Builder
    public OrdersUpdateRequestDto(String address0, String address1, int addressnum,String phonenum,Long shippingnum,String shipname){
        this.address0 = address0;
        this.address1 = address1;
        this.addressnum = addressnum;
        this.phonenum = phonenum;
        this.shippingnum = shippingnum;
        this.shipname = shipname;
    }
}
