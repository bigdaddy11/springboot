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
@Entity(name = "t_comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentContent; //내용

    private String commentType; //댓글 대댓글 타입여부 1, 2

    private String userNo;  //유저 foregin key

    private String PostNo;  //게시물 foregin key

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public CommentEntity(String commentContent, String commentType, String userNo, String PostNo){
        this.commentContent = commentContent;
        this.commentType = commentType;
        this.userNo =  userNo;
        this.PostNo =  PostNo;
    }
}


