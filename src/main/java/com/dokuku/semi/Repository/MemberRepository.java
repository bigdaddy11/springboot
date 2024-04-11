package com.dokuku.semi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dokuku.semi.Entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
    Optional<Member> findByEmailAndProvider(String email, String provider);
}
