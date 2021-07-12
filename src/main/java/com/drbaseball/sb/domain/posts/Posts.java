package com.drbaseball.sb.domain.posts;

import com.drbaseball.sb.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter            // 클래스 내 모든 필드의 Getter 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity            // 테이블과 링크될 클래스임(클래스의 카멜케이스 → 언더스코어네이밍으로 테이블매칭
public class Posts extends BaseTimeEntity { // = 실제 DB의 테이블과 매칭될 클래스, Entity 클래스라고도 함
    @Id // 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙(설정 시에만 auto_increment 됨, 복잡한 PK로 잡을 때 등 여러 상황에서 유연하게 대처 가능하므로 이 옵션은 기본으로 추천)
    private Long id;

    // 테이블의 컬럼, 선언하지 않아도 모든 필드가 컬럼이 됨
    // (기본값[VARCHAR(255)] 외에 추가 변경이 필요한 옵션이 있을 경우)
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자에 값 매핑 시 어느 필드-어떤 값을 매핑할지 명확하게 인지 가능
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
