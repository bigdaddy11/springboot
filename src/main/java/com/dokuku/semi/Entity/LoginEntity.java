package com.dokuku.semi.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "t_user")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    private String userId;

    private String userNm;

    private String userPasswd;

    private String userAddress;

    private String userZipcode;

    private String userPhone;

    private String userStatus;

    private String userType;

    private String userToken;

    @CreationTimestamp
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime lastLoginDate;

    @Builder
    public LoginEntity(String id, String nm, String pw, String address, String zip, String phone, 
                        String status, String type, String token, LocalDateTime cdate, LocalDateTime ldate){
        this.userId = id;
        this.userNm = nm;
        this.userPasswd =  pw;
        this.userAddress = address;
        this.userZipcode = zip;
        this.userPhone = phone;
        this.userStatus = status;
        this.userType = type;
        this.userToken = token;
        this.createDate = cdate;
        this.lastLoginDate = ldate;
    }
}


