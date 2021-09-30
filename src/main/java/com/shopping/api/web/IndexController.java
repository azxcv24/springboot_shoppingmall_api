package com.shopping.api.web;

import com.shopping.api.service.PostsService;
import com.shopping.api.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    //index로는 로그인 및 기타 연결 맵핑으로 써먹자

    private final PostsService postsService;
    private final HttpSession httpSession;




    @GetMapping("/")
    public String index(Model model/*, @LoginUser SessionUser */)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser)httpSession.getAttribute("user");
        /*
        if(user!=null)
            model.addAttribute("userName",user.getName());

         */
        return "index.html";
    }



/*

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-update";
    }

    @GetMapping("/posts/deleteAll")
    public String postsDeleteAll(){
        return "posts-deleteAll";
    }

*/
}