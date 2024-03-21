package com.dokuku.semi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dokuku.semi.Entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{
   public List<PostEntity> findByPostId(Long id);
}


