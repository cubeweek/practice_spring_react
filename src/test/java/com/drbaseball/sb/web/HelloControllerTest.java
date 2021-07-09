package com.drbaseball.sb.web;

import com.drbaseball.sb.web.HelloController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트 진행 시 JUnit의 내장된 실행자 외에 다른 실행자를 실행(SpringRunner)
// 스프링 부트 테스트와 JUnit 사이의 연결자 역할
// WebMvcTest는 Web(Spring MVC)에 집중할 수 있는 어노테이션
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입
    private MockMvc mvc; // 웹 API 테스트 시 사용 => 이 클래스로 HTTP GET, POST 등에 대해 API 테스트가 가능해짐

    @Test
    public void helloTest() throws Exception {
        String hello = "hello";

        // /hello 주소로 HTTP GET 요청을 함(chainning 지원으로 연속 검증 가능)
        // .perform 검증1 : HTTP Header의 Status검증(ex : 200, 404, 500 등) => OK이므로 200여부 검증
        // .perform 검증2 : hello인 String을 리턴하는지 확인
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtoTest() throws Exception {
        String name = "nine";
        int amount = 1000;

        // param : 요청 파라미터 설정(String만 허용됨)
        // jsonPath : JSON 응답값을 필드별로 검증 가능, $을 기준으로 필드명 명시
        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
