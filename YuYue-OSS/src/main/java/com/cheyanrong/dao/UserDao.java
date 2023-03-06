package com.cheyanrong.dao;

import com.cheyanrong.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query(nativeQuery = true,value = "SELECT phone FROM User\n" +
            "WHERE (name =?1 OR mail = ?1 OR phone = ?1)")
    public List<String> getPhoneByLogin(String login);
    @Query(" FROM User" +
            "   WHERE (name =:login OR mail =:login OR phone =:login)AND password = :password")
    User login(String login ,String password);
}
