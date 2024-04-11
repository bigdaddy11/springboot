package com.dokuku.semi.Service;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Repository.MemberRepository;
import com.dokuku.semi.config.OAuthAttributes;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
    private final MemberRepository memberRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
            .getProviderDetails()
            .getUserInfoEndpoint()
            .getUserNameAttributeName();

        Map<String, Object> attributes = oAuth2User.getAttributes();
        
        com.dokuku.semi.Entity.Member member = OAuthAttributes.extract(registrationId, attributes);
        member.updateProvider(registrationId);
        member.saveOrUpdate(member);

        Map<String, Object> customAttribute = customAttribute(attributes, userNameAttributeName, member, registrationId);

        return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority(member.getRoleValue())), 
            customAttribute, 
            userNameAttributeName);
    }

    private Map customAttribute(Map attribute, String userNameAttributeName, com.dokuku.semi.Entity.Member member, String registrationId) {
        Map<String, Object> customAttribute = new LinkedHashMap<>();
        customAttribute.put(userNameAttributeName, attribute.get(userNameAttributeName));
        customAttribute.put("provider", registrationId);
        customAttribute.put("nickname", member.getNickname());
        customAttribute.put("email",member.getEmail());
        customAttribute.put("picture",member.getProfileImageUrl());

        return customAttribute;
    }

    private com.dokuku.semi.Entity.Member SaveOrUpdate(com.dokuku.semi.Entity.Member member){
        com.dokuku.semi.Entity.Member newMember = memberRepository.findByEmailAndProvider(member.getEmail(), member.getProvider())
            .map(m -> m.updateNicknameAndEmailAndProfileImg(member.getNickname(), member.getEmail(), member.getProfileImageUrl()))
            .orElse(com.dokuku.semi.Entity.Member.of(member.getNickname(), member.getEmail(), member.getProfileImageUrl(),
                    member.getProvider(), member.getProviderId()));
        
        return memberRepository.save(newMember);
    }
}
