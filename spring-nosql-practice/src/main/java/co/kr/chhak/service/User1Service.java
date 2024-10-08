package co.kr.chhak.service;

import co.kr.chhak.document.User1Document;
import co.kr.chhak.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public List<User1Document> findAllUser1(){
        List<User1Document> user1List = user1Repository.findAll();
        return user1List;
    }

    public User1Document findUser1(String uid){
        Optional<User1Document> optUser1 = user1Repository.findByUid(uid);

        if(optUser1.isPresent()){
            User1Document user1 = optUser1.get();
            return user1;
        }
        return null;
    }

    public User1Document insertUser1(User1Document user1){
        User1Document savedUser1 = user1Repository.save(user1);
        return savedUser1;
    }

    public User1Document updateUser1(User1Document user1){

        Optional<User1Document> optUser1 = user1Repository.findByUid(user1.getUid());

        if(optUser1.isPresent()){
            User1Document savedUser1 = optUser1.get();
            savedUser1.setName(user1.getName());
            savedUser1.setAge(user1.getAge());
            savedUser1.setAddr(user1.getAddr());

            User1Document modifiedUser1 = user1Repository.save(savedUser1);
            return modifiedUser1;
        }

        return null;
    }

    public boolean deleteUser1(String uid){
        Optional<User1Document> optUser1 = user1Repository.deleteByUid(uid);

        if(optUser1.isPresent()){
            return true;
        }

        return false;
    }
}
