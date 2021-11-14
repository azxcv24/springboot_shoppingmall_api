package com.shopping.api.domain.member;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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
    private String email;

    @Column(nullable=false, length=100)
    private String password;

    //회원이름(표시이름)
    @Column(nullable = false)
    private String membername;

    //사용자권한(MemberRole에서 선언)
    @Enumerated(EnumType.STRING)
    //@ColumnDefault("USER") //기본 USER권한 작동안됨
    private MemberRole role;



    @Builder
    public Member(String email, String password, String membername,MemberRole role){
        this.email= email;
        this.password=password;
        this.membername=membername;
        this.role=role;
    }

    public Member update(String email, String password, String membername){
        this.email= email;
        this.password=password;
        this.membername=membername;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
