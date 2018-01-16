package com.sample.databasejdbc.repository;


import com.sample.databasejdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findByUserName(String userName){
        return jdbcTemplate.queryForObject("Select * from user WHERE username=?",new Object[]{userName}, new BeanPropertyRowMapper<>(User.class));
    }
}
