package com.dokuku.semi.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dokuku.semi.Entity.LoginEntity;
import com.dokuku.semi.Service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("member")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService lopginService;

    //모든회원조희
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<LoginEntity>> getAllMember(){
        List<LoginEntity> member = lopginService.findAll();
        return new ResponseEntity<List<LoginEntity>>(member, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<LoginEntity>> getMember(@PathVariable("userId") String userId) {
        List<LoginEntity> member = lopginService.findByuserId(userId);
        return new ResponseEntity<List<LoginEntity>>(member, HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("userId") Long userId) {
        lopginService.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
    // @PutMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    // public ResponseEntity<LoginEntity> updateMember(@PathVariable("mbrNo") Long mbrNo, LoginEntity member) {
    //     lopginService.updateById(mbrNo, member);
    //     return new ResponseEntity<LoginEntity>(member, HttpStatus.OK);
    // }
        //test
    // 회원 입력
    @PostMapping
    public ResponseEntity<LoginEntity> save(LoginEntity member) {
        return new ResponseEntity<LoginEntity>(lopginService.save(member), HttpStatus.OK);
    }

    // 회원 입력
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<LoginEntity> save(HttpServletRequest req, LoginEntity member){
        return new ResponseEntity<LoginEntity>(lopginService.save(member), HttpStatus.OK);
    }
}
