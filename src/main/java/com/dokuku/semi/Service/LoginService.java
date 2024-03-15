package com.dokuku.semi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.LoginEntity;
import com.dokuku.semi.Repository.LoginRepository;

@Service
public class LoginService {
    @Autowired(required = true)
    private LoginRepository loginRepository;

    public List<LoginEntity> findAll() {
        List<LoginEntity> members = new ArrayList<>();
        loginRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<LoginEntity> findById(Long id) {
        Optional<LoginEntity> member = loginRepository.findById(id);
        return member;
    }

    public void deleteById(Long no) {
        loginRepository.deleteById(no);
    }

    public LoginEntity save(LoginEntity member) {
        loginRepository.save(member);
        return member;
    }

    // public void updateById(Long no, LoginEntity member) {
    //     Optional<LoginEntity> e = loginRepository.findById(no);

    //     if (e.isPresent()) {
    //         //e.get().setId(member.toString());
    //         e.get().se
    //         e.get().setName(member.getName());
    //         memberRepository.save(member);
    //     }
    // }
}


