package com.shopping.api.web;

import com.shopping.api.service.PostsService;
import com.shopping.api.web.dto.PostsListResponeseDto;
import com.shopping.api.web.dto.PostsResponseDto;
import com.shopping.api.web.dto.PostsSaveRequestDto;
import com.shopping.api.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


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
    @GetMapping("/api/v1/posts/search") //검색
    public List<PostsListResponeseDto> findByTitle(@RequestParam(value="title",required = true) String title,
                                    @RequestParam( value = "category",required = false) String category){
        return postsService.findByTitle(id);
    }*/

    @GetMapping("/api/v1/posts/listall") //목록전체생성표시
    public List<PostsListResponeseDto> findAllDesc()
    {
        return postsService.findAllDesc();
    }

    @GetMapping("/api/v1/posts/list") //목록생성표시
    public List<PostsListResponeseDto> getOrderPostsCase(@RequestParam( value = "author",required = false) String author,
                                                         @RequestParam( value = "category",required = false) String category,
                                                         @RequestParam( value = "shipping",required = false) String shipping/*,
                                                        @RequestParam( value = "page",required = false) int page*/)
    {

        return postsService.getOrderPostsCase(author,category,shipping);
    }



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
