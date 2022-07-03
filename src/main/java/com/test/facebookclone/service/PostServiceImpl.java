package com.test.facebookclone.service;

import com.test.facebookclone.repository.PostEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostEntityRepository repository;
}
