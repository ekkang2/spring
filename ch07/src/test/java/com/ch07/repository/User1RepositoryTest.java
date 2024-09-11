package com.ch07.repository;

import com.ch07.dto.User1DTO;
import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {

        User1 entity = user1Repository.findUser1ByUid("testt");
        System.out.println(entity);

    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("22");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("22");
        System.out.println(users);

    }


    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("dd", "22");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> users = user1Repository.findUser1ByUidOrName("dd", "dss");
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThan(35);
        System.out.println(users);

    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanEqual(34);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> users = user1Repository.findUser1ByAgeLessThan(35);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeLessThanEqual(35);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> users = user1Repository.findUser1ByAgeBetween(35, 70);
        System.out.println(users);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> users = user1Repository.findUser1ByNameLike("%22");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> users = user1Repository.findUser1ByNameContains("2");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> users = user1Repository.findUser1ByNameStartsWith("d");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> users = user1Repository.findUser1ByNameEndsWith("s");
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> users = user1Repository.findUser1ByOrderByName();   // name 필드에 따라 결과를 오름차순으로 정렬
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(65);
        System.out.println(users);
    }

    @Test
    void countUser1ByUid() {
        int count = user1Repository.countUser1ByUid("testt");
        System.out.println(count);
    }

    @Test
    void countUser1ByName() {
        int count = user1Repository.countUser1ByName("22");
        System.out.println(count);
    }

    @Test
    void selectUser1UnderAge30() {

    }

    @Test
    void selectUser1WhereName() {

    }

    @Test
    void selectUser1WhereNameParam() {

    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");

        System.out.println(list.size());

        for(Object[] obj : list) {
            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent);
            System.out.println(child);
        }

    }
}