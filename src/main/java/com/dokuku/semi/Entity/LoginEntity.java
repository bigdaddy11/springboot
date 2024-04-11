package com.dokuku.semi.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "t_user")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userNo;

    private String userNm;

    private String userPasswd;

    private String userAddress;

    private String userZipcode;

    private String userPhone;

    private String userStatus;

    private String userType;

    private String userToken;

    private String provider;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public LoginEntity(String no, String nm, String pw, String address, String zip, String phone, 
                        String status, String type, String token, String provider){
        this.userNo = no;
        this.userNm = nm;
        this.userPasswd =  pw;
        this.userAddress = address;
        this.userZipcode = zip;
        this.userPhone = phone;
        this.userStatus = status;
        this.userType = type;
        this.userToken = token;
        this.provider = provider;
    }
}


