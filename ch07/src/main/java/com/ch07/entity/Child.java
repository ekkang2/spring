package com.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.context.annotation.Primary;

// Entity는 @Setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                  // 엔티티 객체 정의
@Table(name = "child")   // 매핑 테이블 설정
public class Child {

    @Id // PK 컬럼 설정(엔티티에 반드시 선언)
    private String cid;
    private String name;
    private String hp;
    private String parent;





}
