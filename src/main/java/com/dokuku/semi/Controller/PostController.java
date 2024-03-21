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

import com.dokuku.semi.Entity.PostEntity;
import com.dokuku.semi.Service.PostService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("post")
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PostService postService;

    //모든게시물조희
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<PostEntity>> getAllpost(){
        List<PostEntity> post = postService.findAll();
        return new ResponseEntity<List<PostEntity>>(post, HttpStatus.OK);
    }

    // 게시물번호로 한명의 게시물 조회
    @GetMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<PostEntity>> getpost(@PathVariable("postId") Long postId) {
        List<PostEntity> post = postService.findByPostId(postId);
        return new ResponseEntity<List<PostEntity>>(post, HttpStatus.OK);
    }

    // 게시물번호로 게시물 삭제
    @DeleteMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deletepost(@PathVariable("postId") Long postId) {
        postService.deleteById(postId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //게시물번호로 게시물 수정(mbrNo로 게시물을 찾아 post 객체의 id, name로 수정함)
    @PutMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<PostEntity> updatepost(@PathVariable("postId") Long postId, PostEntity post) {
        postService.updateById(postId, post);
        return new ResponseEntity<PostEntity>(post, HttpStatus.OK);
    }
        //test
    // 게시물 입력
    @PostMapping
    public ResponseEntity<PostEntity> save(PostEntity post) {
        return new ResponseEntity<PostEntity>(postService.save(post), HttpStatus.OK);
    }

    // 게시물 입력
    @RequestMapping(value="/savepost", method = RequestMethod.GET)
    public ResponseEntity<PostEntity> save(HttpServletRequest req, PostEntity post){
        return new ResponseEntity<PostEntity>(postService.save(post), HttpStatus.OK);
    }

}
