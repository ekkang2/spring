package co.kr.chhak.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private int age;
    private String addr;

}
