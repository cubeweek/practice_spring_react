package com.drbaseball.sb.web.dto;

import org.junit.Test;

// JUnit에 비해 CoreMatchers가 불필요함
// 자동완성이 더 확실하게 지원됨
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_func_test() {
        // given
        String name = "Test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // 생성자로 값이 세팅되었는지 확인
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}