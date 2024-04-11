package com.dokuku.semi.config;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import com.dokuku.semi.Entity.Member;

public enum OAuthAttributes {
    GOOGLE("google",(attributes) -> {
        return Member.of(
            (String) attributes.get("name"),
            (String) attributes.get("email"),
            (String) attributes.get("picture"),
            "google",
            "google_"+ attributes.get("sub")
        );
    });

    private final String registrationId;
    private final Function<Map<String, Object>, Member> of;

    OAuthAttributes(String registrationId, Function<Map<String, Object>, Member> of){
        this.registrationId = registrationId;
        this.of = of;
    }

    public static Member extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(provider -> registrationId.equals(provider.registrationId))
                .findFirst()
                .orElseThrow()
                .of.apply(attributes);
    }
}
