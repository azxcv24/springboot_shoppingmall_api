package com.shopping.api.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRole {

    GUEST("ROLE_GUSET","손님"),
    USER("ROLE_USER","일반 사용자"),
    SELLER("ROLE_SELLER","판매자"),
    ADMIN("ROLE_ADMIN","관리자");

    private String key;
    private String title;
}
