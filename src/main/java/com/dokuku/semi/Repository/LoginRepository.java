package com.dokuku.semi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dokuku.semi.Entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
   public List<LoginEntity> findByUserNo(String userNo);

   public List<LoginEntity> findByUserId(Long userId);

   public List<LoginEntity> findByuserNm(String name);

   public List<LoginEntity> findByuserNmLike(String keyword);

   //public void updateById(int id);

}


