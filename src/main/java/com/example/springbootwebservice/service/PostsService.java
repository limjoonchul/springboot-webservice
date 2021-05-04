package com.example.springbootwebservice.service;

import com.example.springbootwebservice.domain.Posts;
import com.example.springbootwebservice.dto.PostsSaveRequestDto;
import com.example.springbootwebservice.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
