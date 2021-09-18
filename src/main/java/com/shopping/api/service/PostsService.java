package com.shopping.api.service;

import com.shopping.api.domain.posts.Posts;
import com.shopping.api.domain.posts.PostsRepository;
import com.shopping.api.web.dto.PostsListResponeseDto;
import com.shopping.api.web.dto.PostsResponseDto;
import com.shopping.api.web.dto.PostsSaveRequestDto;
import com.shopping.api.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //상품 업데이트
    @Transactional
    public Long Update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("헤당 상품이 없습니다 id = " + id));
        posts.update(requestDto.getTitle(),requestDto.getContent(), requestDto.getCategory(), requestDto.getPrice0(), requestDto.getPrice1(),
                requestDto.getDiscount(), requestDto.getShipping(), requestDto.getShipping_price(), requestDto.getContent_img(), requestDto.getPreview_img());
        return id;
    }

    //상품ID를 이용해서 글검색
    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 상품이 없습니다 id = " + id));
        return new PostsResponseDto(entity);
    }

    //상품리스트
    @Transactional
    public List<PostsListResponeseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponeseDto::new).collect(Collectors.toList());

    }


    //상품삭제
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    @Transactional
    public void deleteAll(){
        postsRepository.deleteAll();
    }


}
