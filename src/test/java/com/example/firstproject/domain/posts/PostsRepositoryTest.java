package com.example.firstproject.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayName("PostsRepository 테스트")
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp(){
        //postsRepository.deleteAll();
    }

    @Test
    public void addAll(){
        String title    = "제목";
        String content  = "내용요용ㅇ";
        String author   = "작성자!!!";

        postsRepository.save(Posts.builder()
                                .title(title)
                                .content(content)
                                .author(author)
                                .build()
        );

        List<Posts> postList = postsRepository.findAll();
        Posts post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getAuthor()).isEqualTo(author);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,11,4,0,0,0);
        postsRepository.save(Posts.builder()
                            .title("title")
                            .content("content")
                            .author("author")
                            .build());

        //when
        List<Posts> listPosts = postsRepository.findAll();

        //then
        listPosts.stream().forEach(s -> {
            System.out.println("s : " + s);
            assertThat(s.getCreatedDate()).isAfter(now);
            assertThat(s.getModifiedDate()).isAfter(now);
        });
    }
}
