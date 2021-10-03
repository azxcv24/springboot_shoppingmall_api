package com.shopping.api.web.dto.member;

import com.shopping.api.domain.member.Member;
import com.shopping.api.domain.member.MemberRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberCreateRequestDto {
    private String memberemail;
    private String memberpasswd;
    private String membername;
    private LocalDateTime createdData;
    private LocalDateTime modifiedDate;
    private MemberRole role;

    @Builder
    public MemberCreateRequestDto( String memberemail, String memberpasswd, String membername, MemberRole role){
        this.memberemail = memberemail;
        this.memberpasswd = memberpasswd;
        this.membername = membername;
        this.role=role;

    }

    public Member toEntity(){
        return Member.builder()
                .memberemail(memberemail)
                .memberpasswd(memberpasswd)
                .membername(membername)
                .role(role)
                .build();
    }

}
