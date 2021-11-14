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
    private Long price0;
    private Long price1;
    private Long discount;
    private String shipping;
    private Long shipping_price;
    private String content_img;
    private String preview_img;


    @Builder
    public PostsUpdateRequestDto(String title, String content, String category, Long price1, Long price0, Long discount,
                                 Long shipping_price, String shipping, String content_img, String preview_img){
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
