package com.cheyanrong.service;

import com.cheyanrong.model.Role;
import com.cheyanrong.model.Promiss;
import com.cheyanrong.model.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(Integer id);
    public boolean updateUser(User role);
    public User getUserById(Integer id);
    public List<User> getUsers();
    public User login(String login,String password);//只能够传明文的密码
    public User setRole(User user);
    public boolean addRole(Role role);
    public boolean deleteRole(Integer id);
    public boolean updateRole(Role role);
    public Role getRoleById(Integer id);
    public List<Role> getRoles();

    public boolean addPromiss(Promiss promiss);
    public boolean deletePromiss(Integer id);
    public boolean updatePromiss(Promiss promiss);
    public Promiss getPromissById(Integer id);
    public List<Promiss> getPromisss();

}
