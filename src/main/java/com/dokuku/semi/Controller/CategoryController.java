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

import com.dokuku.semi.Entity.CategoryEntity;
import com.dokuku.semi.Service.CategoryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryService categoryService;

    //모든게시물조희
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CategoryEntity>> getAllcategory(){
        List<CategoryEntity> category = categoryService.findAll();
        return new ResponseEntity<List<CategoryEntity>>(category, HttpStatus.OK);
    }

    // 게시물번호로 한명의 게시물 조회
    @GetMapping(value = "/{categoryId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CategoryEntity>> getcategory(@PathVariable("categoryId") Long categoryId) {
        List<CategoryEntity> category = categoryService.findByCategoryId(categoryId);
        return new ResponseEntity<List<CategoryEntity>>(category, HttpStatus.OK);
    }

    // 게시물번호로 게시물 삭제
    @DeleteMapping(value = "/{categoryId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deletecategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteById(categoryId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //게시물번호로 게시물 수정(mbrNo로 게시물을 찾아 category 객체의 id, name로 수정함)
    @PutMapping(value = "/{categoryId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CategoryEntity> updatecategory(@PathVariable("categoryId") Long categoryId, CategoryEntity category) {
        categoryService.updateById(categoryId, category);
        return new ResponseEntity<CategoryEntity>(category, HttpStatus.OK);
    }
        //test
    // 게시물 입력
    @PostMapping
    public ResponseEntity<CategoryEntity> save(CategoryEntity category) {
        return new ResponseEntity<CategoryEntity>(categoryService.save(category), HttpStatus.OK);
    }

    // 게시물 입력
    @RequestMapping(value="/savecategory", method = RequestMethod.GET)
    public ResponseEntity<CategoryEntity> save(HttpServletRequest req, CategoryEntity category){
        return new ResponseEntity<CategoryEntity>(categoryService.save(category), HttpStatus.OK);
    }

}
