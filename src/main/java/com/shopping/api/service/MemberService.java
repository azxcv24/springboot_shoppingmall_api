package com.shopping.api.service;

import com.shopping.api.domain.member.Member;
import com.shopping.api.domain.member.MemberRepository;
import com.shopping.api.domain.member.MemberRole;
import com.shopping.api.web.dto.member.MemberCreateRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService{

    private MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long joinuser(MemberCreateRequestDto MemberDto) {

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        MemberDto.setPassword(passwordEncoder.encode(MemberDto.getPassword()));

        return memberRepository.save(MemberDto.toEntity()).getId();
    }

    //loadUserByUsername() 상세정보조회 메소드
    @Override
    public UserDetails loadUserByUsername(String memberemail) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        Optional<Member> userEntityWrapper = memberRepository.findByEmail(memberemail);
        Member userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        //초기룰값 지정
        if (("admin@example.com").equals(memberemail)) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getKey()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getKey()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
}
