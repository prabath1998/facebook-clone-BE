package com.test.facebookclone.service;

import com.test.facebookclone.entity.PostEntity;
import com.test.facebookclone.model.Post;
import com.test.facebookclone.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostEntityRepository repository;

    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);

            if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null")){
                postEntity.setImage(post.getFile());
            }else{
                post.setImage(null);
            }
            postEntity = repository.save(postEntity);

            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());
        }catch (Exception e){
            throw new Exception("Could not save Post: " + e);
        }
        return post;
    }
}
