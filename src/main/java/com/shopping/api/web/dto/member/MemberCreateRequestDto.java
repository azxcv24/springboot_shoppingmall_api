package com.shopping.api.web.dto.member;

import com.shopping.api.domain.member.Member;
import com.shopping.api.domain.member.MemberRole;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberCreateRequestDto /*implements UserDetails*/ {
    private String email;
    private String password;
    private String membername;
    private MemberRole role;
    private LocalDateTime createdData;
    private LocalDateTime modifiedDate;

    @Builder
    public MemberCreateRequestDto( String email, String password, String membername, MemberRole role){
        this.email = email;
        this.password = password;
        this.membername = membername;
        this.role=role;

    }

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .membername(membername)
                .role(role)
                .build();
    }

}
