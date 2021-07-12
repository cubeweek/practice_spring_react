package com.drbaseball.sb.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // JUnit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveNotice_called() {
        String title = "Do you want hands clap?";
        String content = "hands clap 5 times!";

        // save    : 테이블에 insert / update 쿼리 실행(id 매치시 insert, 없을 시 update)
        postsRepository.save(Posts.builder()
                                .title(title)
                                .content(content)
                                .author("dr.baseball805@gmail.com")
                                .build());

        // when
        // findAll : 테이블의 모든 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getTitle()).isEqualTo(title);
    }

    @Test
    public void BaseTimeEntity_register() {
        // given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>> Create Date is...? " + posts.getCreatedDate() + ", Modified Date is..." + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
