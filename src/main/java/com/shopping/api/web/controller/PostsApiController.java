package com.shopping.api.web.controller;

import com.shopping.api.service.PostsService;
import com.shopping.api.web.dto.posts.PostsListResponeseDto;
import com.shopping.api.web.dto.posts.PostsResponseDto;
import com.shopping.api.web.dto.posts.PostsSaveRequestDto;
import com.shopping.api.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*") //CORS허용
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")  //저장
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}") //수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.Update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") //조회
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }


    @GetMapping("/api/v1/posts/search") //검색
    public Page<PostsListResponeseDto> findAllKeywordWithPagination(@RequestParam( value = "category",required = false) String category,
                                                                    @RequestParam( value = "keyword") String keyword,
                                                                    @PageableDefault(size = 20, sort = "id") Pageable pageable){
        return postsService.findAllKeywordWithPagination(category,keyword, pageable);
    }

    @GetMapping("/api/v1/posts/listall") //목록전체생성표시
    public List<PostsListResponeseDto> findAllDesc()
    {
        return postsService.findAllDesc();
    }

    @GetMapping("/api/v1/posts/list") //
    public Page<PostsListResponeseDto> findAllPostsWithPagination(@RequestParam( value = "author",required = false) String author,
                                                                  @RequestParam( value = "category",required = false) String category,
                                                                  @RequestParam( value = "shipping",required = false) String shipping,
                                                                  @PageableDefault(size = 20, sort = "id") Pageable pageable)
    {
        return postsService.findAllPostsWithPagination(author, category, shipping, pageable);
    }


    //TODO 작성자만 삭제 가능하게
    @DeleteMapping("/api/v1/posts/{id}") //삭제
    public Long delete(@PathVariable Long id){

        postsService.delete(id);
        return id;
    }

    /*
    @DeleteMapping("/api/v1/posts/all") //전부 삭제
    public void deleteAll(){
        postsService.deleteAll();

    }
    */


}
