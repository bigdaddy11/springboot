package com.dokuku.semi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_USER"),
    GUEST("ROLE_USER");

    private final String value;
}
