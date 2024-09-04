package com.ch04.dao;


import com.ch04.dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User1DAO {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User1DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User1DTO dto){

        String sql = "insert into `user1` values (?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
            };

        jdbcTemplate.update(sql, params);
    }

    public User1DTO selectUser1(String uid){
        return null;
    }
    public List<User1DTO> selectUser1s(){
        return null;
    }
    public void updateUser1(User1DTO dto){

    }
    public void deleteUser1(String uid){

    }
}
