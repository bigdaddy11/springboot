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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dokuku.semi.Entity.LoginEntity;
import com.dokuku.semi.Service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("login")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService lopginService;

    //모든회원조희
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<LoginEntity>> getAlllogin(){
        List<LoginEntity> login = lopginService.findAll();
        return new ResponseEntity<List<LoginEntity>>(login, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<LoginEntity>> getlogin(@PathVariable("userId") Long userId) {
        List<LoginEntity> login = lopginService.findByuserId(userId);
        return new ResponseEntity<List<LoginEntity>>(login, HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deletelogin(@PathVariable("userId") Long userId) {
        lopginService.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //회원번호로 회원 수정(mbrNo로 회원을 찾아 login 객체의 id, name로 수정함)
    @PutMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<LoginEntity> updatelogin(@PathVariable("userId") Long userId, LoginEntity login) {
        lopginService.updateById(userId, login);
        return new ResponseEntity<LoginEntity>(login, HttpStatus.OK);
    }
        //test
    // 회원 입력
    @PostMapping
    public ResponseEntity<LoginEntity> save(LoginEntity login) {
        return new ResponseEntity<LoginEntity>(lopginService.save(login), HttpStatus.OK);
    }

    // 회원 입력
    @RequestMapping(value="/savelogin", method = RequestMethod.GET)
    public ResponseEntity<LoginEntity> save(HttpServletRequest req, LoginEntity login){
        return new ResponseEntity<LoginEntity>(lopginService.save(login), HttpStatus.OK);
    }

    
   /* 핸드폰번호 변경 */

   /* 닉네임 변경 */

   /* 비밀번호 변경 */

   /* 주소 변경 */
}
