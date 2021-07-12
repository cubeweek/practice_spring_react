package com.drbaseball.sb.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// DB Layer 접근자, JPA에서는 Repository라 부르고 interface로 생성함
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
