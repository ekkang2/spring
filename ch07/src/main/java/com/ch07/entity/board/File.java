package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;

// Entity는 @Setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                  // 엔티티 객체 정의
@Table(name = "board_file")   // 매핑 테이블 설정
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    private String oName;
    private String sName;

    @ManyToOne(fetch = FetchType.LAZY) // article의 OneToMany와 양방향 관계
    @JoinColumn(name = "ano")
    private Article article;
}
