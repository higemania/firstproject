package com.example.firstproject.controller;

import com.example.firstproject.dto.PostsResponseDto;
import com.example.firstproject.dto.PostsSaveRequestDto;
import com.example.firstproject.dto.PostsUpdateRequestDto;
import com.example.firstproject.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
}
