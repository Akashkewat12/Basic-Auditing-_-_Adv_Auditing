package com.coding.prod_ready_feature.prod_ready_feature.service;

import com.coding.prod_ready_feature.prod_ready_feature.dto.PostDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto inputPost, Long postId);
}
