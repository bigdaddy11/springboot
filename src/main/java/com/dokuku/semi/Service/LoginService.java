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

    public List<LoginEntity> findByUserNo(String userNo) {
        List<LoginEntity> member = loginRepository.findByUserNo(userNo);
        return member;
    }

    public void deleteById(Long id) {
        loginRepository.deleteById(id);
    }

    public LoginEntity save(LoginEntity member) {
        loginRepository.save(member);
        return member;
    }

    public void updateById(Long id, LoginEntity member) {
        Optional<LoginEntity> e = loginRepository.findById(id);

        if (e.isPresent()) {
            //e.get().setId(member.toString());
            loginRepository.save(member);
        }
    }
}


