package com.coding.prod_ready_feature.prod_ready_feature.service;

import com.coding.prod_ready_feature.prod_ready_feature.dto.PostDto;
import com.coding.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import com.coding.prod_ready_feature.prod_ready_feature.exception.ResourceNotFoundException;
import com.coding.prod_ready_feature.prod_ready_feature.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity ->
                modelMapper.map(postEntity, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @SneakyThrows
    @Override
    public PostDto getPostById(Long postId)  {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Post not found with this id " + postId));

        return modelMapper.map(postEntity, PostDto.class);
    }

    @SneakyThrows
    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        PostEntity olderPost=postRepository.findById(postId)
        .orElseThrow(()->new ResourceNotFoundException("Post not found with id"+postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);// input consider as source and older post consider as destination
        PostEntity savedPostEntity=postRepository.save(olderPost);

        return modelMapper.map(savedPostEntity, PostDto.class);
    }
}
