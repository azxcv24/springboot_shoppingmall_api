package com.shopping.api.web.dto.posts;

import com.shopping.api.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String category;
    private Long price0;
    private Long price1;
    private Long discount;
    private String shipping;
    private Long shipping_price;
    private String content_img;
    private String preview_img;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.price0 =entity.getPrice0();
        this.price1 = entity.getPrice1();
        this.discount = entity.getDiscount();
        this.shipping = entity.getShipping();
        this.shipping_price = entity.getShipping_price();
        this.content_img = entity.getContent_img();
        this.preview_img = entity.getPreview_img();
    }
}
//상품 상세(id당 조회) 보려고 불러오는 DTO
