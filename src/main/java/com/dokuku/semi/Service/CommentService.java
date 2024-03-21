package com.dokuku.semi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.CommentEntity;
import com.dokuku.semi.Repository.CommentRepository;

@Service
public class CommentService {
    @Autowired(required = true)
    private CommentRepository CommentRepository;

    public List<CommentEntity> findAll() {
        List<CommentEntity> Comments = new ArrayList<>();
        CommentRepository.findAll().forEach(e -> Comments.add(e));
        return Comments;
    }

    // public List<CommentEntity> findByuserId(Long id) {
    //     List<CommentEntity> Comment = CommentRepository.findByuserId(id);
    //     return Comment;
    // }

    public void deleteById(Long id) {
        CommentRepository.deleteById(id);
    }

    public CommentEntity save(CommentEntity Comment) {
        CommentRepository.save(Comment);
        return Comment;
    }

    public void updateById(Long id, CommentEntity Comment) {
        Optional<CommentEntity> e = CommentRepository.findById(id);

        if (e.isPresent()) {
            //e.get().setId(Comment.toString());
            CommentRepository.save(Comment);
        }
    }
}


