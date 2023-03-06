package com.cheyanrong.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.crypto.SecureUtil;
import com.cheyanrong.dao.PromissDao;
import com.cheyanrong.dao.RoleDao;
import com.cheyanrong.dao.UserDao;

import com.cheyanrong.model.Promiss;
import com.cheyanrong.model.Role;
import com.cheyanrong.model.User;
import com.cheyanrong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired   //先按类型，后按名字；@Resource 先按名字，后按类型
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PromissDao promissDao;

    @Override
    public boolean addUser(User user) {
        try {
            // 给明文+salt（盐值） 明文相同，密文不同
            String password = SecureUtil.md5(user.getPassword()+user.getPhone());
            System.out.println(password);
            user.setPassword(password);
            userDao.save(user);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            userDao.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }


    @Override
    public boolean updateUser(User user) {
        //提前copy原数据
        User old = userDao.findById(user.getId()).get();
        CopyOptions copyOption = CopyOptions.create(null,true);
        //把新的非null数据合并
        BeanUtil.copyProperties(user,old,copyOption);
        try {
            userDao.save(old);
            BeanUtil.copyProperties(old,user,copyOption);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User login(String login, String password) {
        //        1.查出匹配手机号的集合
        List<String> phones = userDao.getPhoneByLogin(login);
        System.out.println(phones);
        //        2.遍历集合，匹配第一个登录操作，遇到第一个登录成功退出
        for(String phone:phones){
            User user = userDao.login(login,SecureUtil.md5(password+phone));
            if(user!=null){
                return user;
            }
        }
        return  null;
    }

    @Override
    public User setRole(User user) {
        if(updateUser(user)){
            return user;
        }
        return null;
    }

    @Override
    public boolean addRole(Role role) {
        try {
            roleDao.save(role);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean deleteRole(Integer id) {
        try {
            roleDao.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean updateRole(Role role) {
        //提前copy原数据
        Role old = roleDao.findById(role.getId()).get();
        CopyOptions copyOption = CopyOptions.create(null,true);
        //把新的非null数据合并
        BeanUtil.copyProperties(role,old,copyOption);
        try {
            roleDao.save(old);
            BeanUtil.copyProperties(old,role,copyOption);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findById(id).get();
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.findAll();
    }

    @Override
    public boolean addPromiss(Promiss promiss) {
        try {

            promissDao.save(promiss);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean deletePromiss(Integer id) {
        try {
            promissDao.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;

    }

    @Override
    public boolean updatePromiss(Promiss promiss) {
        //提前copy原数据
        Promiss old = promissDao.findById(promiss.getId()).get();
        CopyOptions copyOption = CopyOptions.create(null,true);
        //把新的非null数据合并
        BeanUtil.copyProperties(promiss,old,copyOption);
        try {
            promissDao.save(old);
            BeanUtil.copyProperties(old,promiss,copyOption);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
//            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public Promiss getPromissById(Integer id) {
        return promissDao.findById(id).get();
    }

    @Override
    public List<Promiss> getPromisss() {
        return promissDao.findAll();
    }
}
