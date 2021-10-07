package com.shopping.api.config.auth.dto;

import com.shopping.api.domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String email;
    private String membername;

    public SessionUser(Member member){
        this.email = member.getEmail();
        this.membername = member.getMembername();
    }
}
