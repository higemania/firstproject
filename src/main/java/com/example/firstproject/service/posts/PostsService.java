package com.example.firstproject.service.posts;

import com.example.firstproject.domain.posts.Posts;
import com.example.firstproject.domain.posts.PostsRepository;
import com.example.firstproject.dto.PostsResponseDto;
import com.example.firstproject.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                    .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id : " + id));
        posts.update(requestDto);

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id)
                                    .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id : " + id));
        return new PostsResponseDto(posts);
    }

}
