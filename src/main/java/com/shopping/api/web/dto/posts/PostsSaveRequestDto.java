package com.shopping.api.web.dto.posts;


import com.shopping.api.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    
    private String title; //상품명
    private String content; //상품내용
    private String author; //작성자ID
    private String category; //상품 카테고리
    private long price0; //원래가격
    private long price1; //할인적용가격
    private long discount; //할인율
    private String shipping; //배송종류(프론트에서 선택형으로)
    private long shipping_price; //배송비
    private String content_img; //상품 상세정보 이미지 링크
    private String preview_img; //정사각형 미리보기 이미지 링크

    @Builder
    public  PostsSaveRequestDto(String title, String content ,String author, String category, long price0, long discount,
                                long price1, String shipping, long shipping_price, String content_img, String preview_img){
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

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .category(category)
                .price0(price0)
                .price1(price1)
                .discount(discount)
                .shipping(shipping)
                .shipping_price(shipping_price)
                .content_img(content_img)
                .preview_img(preview_img)
                .build();
    }
    
}
//게시글 저장 Dto
