package com.shopping.api.web;

import com.shopping.api.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*") //CORS허용
@RestController
@AllArgsConstructor
public class MemberApiController {
    private MemberService memberService;

    //return
}

