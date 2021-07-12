package com.drbaseball.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 프로젝트의 메인 클래스
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // main의 SpringApplication.run으로 인해 내장 WAS를 실행하므로 따로 tomcat을 설정할 필요 없음
        // 스프링 부트는 내장 WAS를 사용하는 것을 권장함
        //  '언제 어디서나 같은 환경에서 스프링 부트를 배포'할 수 있기 때문
        // 성능상 이슈는 높은 트래픽의 서비스에서도 무난하게 사용하고 있으므로 크게 문제되는 부분은 없음
        SpringApplication.run(Application.class, args);
    }
}
