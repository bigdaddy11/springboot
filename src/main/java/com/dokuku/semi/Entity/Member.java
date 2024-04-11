package com.dokuku.semi.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "t_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "profile_img_url")
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(name = "provider_type")
    private String provider;

    @Column(name = "provider_id")
    private String providerId;

    //@Builder(access = AccessLevel.PRIVATE)
    @Builder
    private Member(String nickname, String email, String profileImageUrl, String provider, String providerId) {
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.role = MemberRole.USER;
        this.provider = provider;
        this.providerId = providerId;
    }
    
    public static Member of(String nickname, String email, String profileImageUrl, String provider, String providerId) {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .profileImageUrl(profileImageUrl)
                .provider(provider)
                .providerId(providerId)
                .build();
    }

    public Member updateNicknameAndEmailAndProfileImg(String nickname, String email, String profileImageUrl) {
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        return this;
    }

    public Member updateProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getRoleValue(){
        return this.getRole().getValue();
    }

    public void saveOrUpdate(Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrUpdate'");
    }

}
