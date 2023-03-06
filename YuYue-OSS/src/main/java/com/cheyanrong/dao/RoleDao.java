package com.cheyanrong.dao;

import com.cheyanrong.model.Role;
import com.cheyanrong.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {

}
