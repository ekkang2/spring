package com.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor // 매개변수가 없는 생성자
@AllArgsConstructor // 모든 속성을 매개변수로 선언한 생성자
@Builder
public class User2DTO {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

}
