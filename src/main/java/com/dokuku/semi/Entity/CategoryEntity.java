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
@Entity(name = "t_category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryNo;

    private String CategoryCode; //코드

    private String CategoryTitle; //내용

    private String CategoryType; // 카테고리 타입

    @CreationTimestamp
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime lastLoginDate;

    @Builder
    public CategoryEntity(String CategoryCode, String CategoryTitle, String CategoryType, LocalDateTime cdate, LocalDateTime ldate){
        this.CategoryCode = CategoryCode;
        this.CategoryTitle = CategoryTitle;
        this.CategoryType =  CategoryType;
        
        this.createDate = cdate;
        this.lastLoginDate = ldate;
    }
}


