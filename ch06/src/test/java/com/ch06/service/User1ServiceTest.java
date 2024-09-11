package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    @Order(1)
    @DisplayName("user1 등록")
    void insertUser1() {

        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 실행하기 위한 준비
        User1DTO sample = User1DTO.builder()
                            .uid("a206")
                            .name("김유신")
                            .birth("1999-01-02")
                            .hp("010-2222-1010")
                            .age(22)
                            .build();

        // when : 테스트를 진행
        user1Service.insertUser1(sample);

        // then : 테스트 검증, Assert 단정문을 이용해 결과 출력
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Test
    @Order(2)
    @DisplayName("user1 조회")
    void selectUser1() {

        // given
        String uid = "a206";

        // when
        User1DTO expected = user1Service.selectUser1(uid);

        // then
        Assertions.assertEquals(expected.getUid(), uid);

    }

    @Test
    @Order(3)
    @DisplayName("user1 전체 조회")
    void selectUser1s() {

        List<User1DTO> expected = user1Service.selectUser1s();

        Assertions.assertFalse(expected.isEmpty()); // 테스트 통과
        //Assertions.assertTrue(expected.isEmpty());  // 테스트 실패

    }

    @Test
    @Order(4)
    @DisplayName("user1 수정")
    void updateUser1() {
        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 실행하기 위한 준비
        User1DTO sample = User1DTO.builder()
                .uid("m101")
                .name("김유진")
                .birth("1999-01-22")
                .hp("010-2222-2222")
                .age(22)
                .build();

        user1Service.updateUser1(sample);

        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Test
    @Order(5)
    @DisplayName("user1 삭제")
    void deleteUser1() {
        String uid = "test";
        user1Service.deleteUser1(uid);

        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertNull(expected);

    }
}