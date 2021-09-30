package com.shopping.api.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키
    private long id;

    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition="text", nullable=false)
    private String content;

    private String author;

    @Column(nullable=false)
    private String category;

    private long price0;

    @Column(nullable=false)
    private long price1;

    private long discount;

    @Column(length=200, nullable=false)
    private String shipping;

    @Column(nullable=false)
    private long shipping_price;

    private String content_img;

    private String preview_img;

    @Builder
    public Posts(String title, String content, String author, String category,long price0, long price1, long discount, String shipping, long shipping_price, String content_img, String preview_img){
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.price0 = price0;
        this.price1 = price1;
        this.discount = discount;
        this.shipping = shipping;
        this.shipping_price = shipping_price;
        this.content_img = content_img;
        this.preview_img = preview_img;
    }

    public void update(String title, String content, String category, long price0, long price1, long discount, String shipping, long shipping_price, String content_img, String preview_img){
        this.title = title;
        this.content = content;
        this.category = category;
        this.price0 = price0;
        this.price1 = price1;
        this.discount = discount;
        this.shipping = shipping;
        this.shipping_price = shipping_price;
        this.content_img = content_img;
        this.preview_img = preview_img;
    }
    
}
//테이블 Entity 클래스
