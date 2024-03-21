package com.dokuku.semi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dokuku.semi.Entity.NotiEntity;

@Repository
public interface NotiRepository extends JpaRepository<NotiEntity, Long>{
    public List<NotiEntity> findByNotiId(Long id);
}


