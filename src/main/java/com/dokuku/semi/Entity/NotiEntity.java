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
@Entity(name = "t_noti")
public class NotiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notiNo;

    private String notiTitle;

    private String notiBody;

    private String notiStatus;  //게시 사용 유무

    @CreationTimestamp
    private LocalDateTime createDate;
    
    @LastModifiedDate
    private LocalDateTime lastLoginDate;

    @Builder
    public NotiEntity(String title, String body, String Status, LocalDateTime cdate, LocalDateTime ldate){
        this.notiTitle = title;
        this.notiBody = body;
        this.notiStatus =  Status;
        this.createDate = cdate;
        this.lastLoginDate = ldate;
    }
}


