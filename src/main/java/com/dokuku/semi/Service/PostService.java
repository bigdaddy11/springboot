package com.dokuku.semi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.PostEntity;
import com.dokuku.semi.Repository.PostRepository;

@Service
public class PostService {
    @Autowired(required = true)
    private PostRepository PostRepository;

    public List<PostEntity> findAll() {
        List<PostEntity> posts = new ArrayList<>();
        PostRepository.findAll().forEach(e -> posts.add(e));
        return posts;
    }

    public List<PostEntity> findByPostId(Long id) {
        List<PostEntity> post = PostRepository.findByPostId(id);
        return post;
    }

    public void deleteById(Long id) {
        PostRepository.deleteById(id);
    }

    public PostEntity save(PostEntity post) {
        PostRepository.save(post);
        return post;
    }

    public void updateById(Long id, PostEntity post) {
        Optional<PostEntity> e = PostRepository.findById(id);

        if (e.isPresent()) {
            //e.get().setId(post.toString());
            PostRepository.save(post);
        }
    }
}


