package com.ch09.service;

import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.repository.User2Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// controller > service > repository > db
@RequiredArgsConstructor
@Service
public class User2Service {

    // 생성자 주입
    private final User2Repository user2Repository;

    public User2 insertUser2(User2DTO user2DTO){

        // DTO를 Entity로 변환
        User2 entity = user2DTO.toEntity();
        // Entity 저장(데이터베이스 Insert)
        return user2Repository.save(entity);

    }

    public User2DTO selectUser2(String uid){

        /*
            Optional
             - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
             - Spring JPA find~ 메서드의 결과 타입
         */
        Optional<User2> opt = user2Repository.findById(uid);

        // Entity 존재 여부 확인
        if(opt.isPresent()){
            // Optional 타입으로 정의된 Entity 가져오기
            User2 user2 = opt.get();

            // Entity를 DTO로 변환해서 반환
            return user2.toDTO();
        }
        return null;
    }

    // list 전체 조회
    public List<User2DTO> selectUser2s(){

        // Entity 전체 조회
        List<User2> user2s = user2Repository.findAll();

        // for(외부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        /*
         List<User1DTO> user1DTOS = new ArrayList<>();

         for(User1 user1 : user1s){
            user1DTOS.add(user1.toDTO());
         }
         */

        // List stream(내부반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        List<User2DTO> users = user2s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public User2 updateUser2(User2DTO user2DTO){

        // Entity 존재여부 확인
        boolean result = user2Repository.existsById(user2DTO.getUid());

        if(result){
            // DTO를 Entity로 변환
            User2 entity = user2DTO.toEntity();
            return user2Repository.save(entity);

        }

       return null;


    }

    public void deleteUser2(String uid){

        if(!user2Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }

        user2Repository.deleteById(uid);
    }


}
