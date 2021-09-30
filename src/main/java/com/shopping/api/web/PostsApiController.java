package com.shopping.api.web;

import com.shopping.api.service.PostsService;
import com.shopping.api.web.dto.PostsListResponeseDto;
import com.shopping.api.web.dto.PostsResponseDto;
import com.shopping.api.web.dto.PostsSaveRequestDto;
import com.shopping.api.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
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

    /*
    @GetMapping("/api/v1/posts/search") //검색 아래 하나로 다 할수 있을듯
    public List<PostsListResponeseDto> findByTitle(@RequestParam(value="title",required = true) String title,
                                    @RequestParam( value = "category",required = false) String category
                                    @RequestParam( value = "keyword") String keyword){
        return postsService.findByTitle(id);
    }*/

    @GetMapping("/api/v1/posts/listall") //TODO 목록전체생성표시(아래껄로 추후 통합사용)
    public List<PostsListResponeseDto> findAllDesc()
    {
        return postsService.findAllDesc();
    }

    @GetMapping("/api/v1/posts/list") //TODO 목록생성표시(페이징 기능에 최대 페이지,페이지사이즈 변수 기능 추가하기)+타이틀 검색 추가
    public List<PostsListResponeseDto> findAllPostsWithPagination(@RequestParam( value = "author",required = false) String author,
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
