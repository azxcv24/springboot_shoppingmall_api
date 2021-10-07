package com.shopping.api.web;


import com.shopping.api.service.MemberService;
import com.shopping.api.web.dto.member.MemberCreateRequestDto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@CrossOrigin(origins = "*", allowedHeaders = "*") //CORS허용
@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;



    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(MemberCreateRequestDto memberDto){
        memberService.joinuser(memberDto);
        return "redirect:/user/login";
    }
    @GetMapping("/user/login")
    public String dispLogin(){
        return "/login";
    }

    @GetMapping("/user/login/result")
    public String dispLoginResult(){
        return "/loginSucess";
    }

    @GetMapping("/user/logout/result")
    public String dispLogout(){
        return "/logout";
    }


    @GetMapping("/user/denied")
    public String dispeDenied(){
        return "/denied";
    }

    @GetMapping("/user/info")
    public String dispMyInfo(){
        return "/myinfo";
    }
    @GetMapping("/admin")
    public String dispAdmin(){
        return "/admin";
    }





    /*
    // 내 정보 페이지
    @GetMapping("/member/info")
    public String info() {
        return "";//리턴 바꾸기 dto로
    }

    @PutMapping("/member/update")
    //정보,비밀번호 업데이트
    
    //
     */






}
