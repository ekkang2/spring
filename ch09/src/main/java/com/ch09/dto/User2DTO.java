package com.ch09.dto;


import com.ch09.entity.User2;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private String addr;
    private int age;
    private String hp;
    public User2 toEntity() {
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .age(age)
                .hp(hp)
                .build();
    }
}