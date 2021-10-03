package com.shopping.api.web.dto.posts;


import com.shopping.api.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsListResponeseDto {

    private long id;
    private String title;
    private String author;
    private String category;
    private long price0;
    private long price1;
    private long discount;
    private String shipping;
    private long shipping_price;
    private String content_img;
    private String preview_img;

    public PostsListResponeseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.price0 = entity.getPrice0();
        this.price1 = entity.getPrice1();
        this.discount = entity.getDiscount();
        this.shipping = entity.getShipping();
        this.shipping_price = entity.getShipping_price();
        this.content_img = entity.getContent_img();
        this.preview_img = entity.getPreview_img();
    }

}
//게시글 리스트 표시 DTO