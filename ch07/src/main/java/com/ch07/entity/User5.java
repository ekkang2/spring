package com.ch07.entity;

import com.ch07.dto.User5DTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user5")
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼)값이 자동 1증가(auto_increment)
    private int seq;

    @Column(name = "name")
    private  String name;

    @Column(name = "gender")
    private  String gender;

    @Column(name = "age")
    private  int age;

    @Column(name = "addr")
    private  String addr;

    // DTO 변환 메서드
    public User5DTO toDTO(){
        return User5DTO.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }



}
