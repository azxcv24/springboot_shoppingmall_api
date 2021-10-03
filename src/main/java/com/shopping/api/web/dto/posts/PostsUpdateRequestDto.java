package com.shopping.api.web.dto.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;
    private String category;
    private long price0;
    private long price1;
    private long discount;
    private String shipping;
    private long shipping_price;
    private String content_img;
    private String preview_img;


    @Builder
    public PostsUpdateRequestDto(String title, String content, String category, long price1, long price0, long discount,
                                 long shipping_price, String shipping, String content_img, String preview_img){
        this.title = title;
        this.content = content;
        this.category = category;
        this.price0 = price0;
        this.price1 = price1;
        this.discount = discount;
        this.shipping_price = shipping_price;
        this.shipping = shipping;
        this.content_img = content_img;
        this.preview_img = preview_img;

    }

}
//게시글 수정 요청 받는 Dto(Data transfer object)
