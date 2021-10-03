package com.shopping.api.domain.member;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Member {
    //회원번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원이메일->로그인 아이디
    @Column(nullable = false, unique = true, length = 40)
    private String memberemail;

    @Column(nullable=false, length=100)
    private String memberpasswd;

    //회원이름(표시이름)
    @Column(nullable = false)
    private String membername;

    //사용자권한(MemberRole에서 선언)
    @Enumerated(EnumType.STRING)
    private MemberRole role;



    @Builder
    public Member(String memberemail, String memberpasswd, String membername, MemberRole role){
        this.memberemail= memberemail;
        this.memberpasswd=memberpasswd;
        this.membername=membername;
        this.role=role;
    }

    public Member update(String memberemail, String memberpasswd, String membername){
        this.memberemail= memberemail;
        this.memberpasswd=memberpasswd;
        this.membername=membername;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
