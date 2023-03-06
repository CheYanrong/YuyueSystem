package com.cheyanrong.service;

import com.cheyanrong.model.Promiss;
import com.cheyanrong.model.Role;
import com.cheyanrong.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    void initData(){
        addUser();
        addRole();
        addPromiss();
    }
    @Test
    void addUser() {
          User teacher1 = new User("杜甫","123456","15120555200","123@qq.com");
//        User user1 = new User("李白","123456","15120555201","1234@qq.com");
//        User user2 = new User("白居易","123456","15120555202","12345@qq.com");
//        User user3 = new User("15120555202","123456","15120555203","123456@qq.com");
          User user1 = new User("小车","Xrj20000117","18293034189","1762734208@qq.com");
          User admin = new User("小辛","Xrj20000117","18293034190","1762734209@qq.com");
          userService.addUser(admin);
          userService.addUser(teacher1);
          userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        System.out.println(user1);
//        System.out.println(user1);
//        System.out.println(user2);
//        System.out.println(user3);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(9);
    }

    @Test
    void updateUser() {
        User user = new User("李商隐","123456","15120555203","123456@qq.com");
        userService.updateUser(user);
        System.out.println(user);
    }

    @Test
    void getUserById() {
        System.out.println(userService.getUserById(24));
    }

    @Test
    void getUsers() {
    }
    @Test
    void login(){
        User login = userService.login("15120555202", "123456");
        System.out.println(login);
    }
    @Test
    void setRole(){
        User user = new User();
        user.setId(1);
        Set<Role> roles = new HashSet<>();

    }
    @Test
    void addRole() {
        Role role = new Role("管理员");
        userService.addRole(role);
        Role role1 = new Role("任课老师");
        userService.addRole(role1);
    }

    @Test
    void deleteRole() {
    }

    @Test
    void updateRole() {
    }

    @Test
    void getRoleById() {
    }

    @Test
    void getRoles() {
    }

    @Test
    void addPromiss() {
        Promiss user = new Promiss("用户管理", "Avatar","",null);
        userService.addPromiss(user);
        Promiss user1 = new Promiss("用户信息", "Document","main/user",null);
        userService.addPromiss(user1);
        Promiss role = new Promiss("角色管理", "Avatar","",null);
        userService.addPromiss(role);
        Promiss role1 = new Promiss("角色信息", "Document","main/role",null);
        userService.addPromiss(role1);
        Promiss promiss = new Promiss("权限管理", "Avatar","",null);
        userService.addPromiss(promiss);
        Promiss promiss1 = new Promiss("权限信息", "Document","main/promiss",null);
        userService.addPromiss(promiss1);
    }

    @Test
    void deletePromiss() {
    }

    @Test
    void updatePromiss() {
    }

    @Test
    void getPromissById() {
    }

    @Test
    void getPromisss() {
    }
}