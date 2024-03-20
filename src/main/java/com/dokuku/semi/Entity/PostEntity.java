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
@Entity(name = "t_Post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostNo;

    private String PostTitle; //제목

    private String PostContent; //내용

    private String CategoryCode; // 게시물 타입

    private String userNo;  //작성 유저 foregin key

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public PostEntity(String PostTitle, String PostContent, String CategoryCode, String userNo){
        this.PostTitle = PostTitle;
        this.PostContent = PostContent;
        this.CategoryCode =  CategoryCode;
        this.userNo =  userNo;
    }
}


