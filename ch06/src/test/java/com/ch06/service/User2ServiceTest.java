package com.ch06.service;

import com.ch06.dto.User1DTO;
import com.ch06.dto.User2DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User2ServiceTest {

    @Autowired
    private User2Service user2Service;

    @Test
    @Order(1)
    @DisplayName("user2 등록")
    void insertUser2() {

        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 실행하기 위한 준비
        User2DTO sample = User2DTO.builder()
                            .uid("a108")
                            .name("김유신")
                            .birth("1999-01-02")
                            .hp("010-2222-1010")
                            .addr("부산광역시")
                            .build();

        // when : 테스트를 진행
        user2Service.insertUser2(sample);

        // then : 테스트 검증, Assert 단정문을 이용해 결과 출력
        User2DTO expected = user2Service.selectUser2(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Test
    @Order(2)
    @DisplayName("user2 조회")
    void selectUser2() {

        // given
        String uid = "a108";

        // when
        User2DTO expected = user2Service.selectUser2(uid);

        // then
        Assertions.assertEquals(expected.getUid(), uid);

    }

    @Test
    @Order(3)
    @DisplayName("user2 전체 조회")
    void selectUser2s() {

        List<User2DTO> expected = user2Service.selectUser2s();

        Assertions.assertFalse(expected.isEmpty()); // 테스트 통과
        //Assertions.assertTrue(expected.isEmpty());  // 테스트 실패

    }

    @Test
    @Order(4)
    @DisplayName("user2 수정")
    void updateUser2() {
        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 실행하기 위한 준비
        User2DTO sample = User2DTO.builder()
                .uid("a106")
                .name("김유진")
                .birth("1999-01-22")
                .hp("010-2222-2222")
                .addr("부산광역시")
                .build();

        user2Service.updateUser2(sample);

        User2DTO expected = user2Service.selectUser2(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Test
    @Order(5)
    @DisplayName("user2 삭제")
    void deleteUser2() {
        String uid = "a105";
        user2Service.deleteUser2(uid);

        User2DTO expected = user2Service.selectUser2(uid);
        Assertions.assertNull(expected);

    }
}