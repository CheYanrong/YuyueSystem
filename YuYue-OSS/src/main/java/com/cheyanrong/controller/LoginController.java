package com.cheyanrong.controller;

import com.cheyanrong.model.LoginForm;
import com.cheyanrong.model.RegGroup;
import com.cheyanrong.model.ResultEntity;
import com.cheyanrong.model.User;
import com.cheyanrong.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginController")
@Api(tags = "登录操作")
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping
    @ApiOperation(value = "登录")
    public ResultEntity<User> add(@RequestBody LoginForm loginForm) {
        User user = userService.login(loginForm.getLoginName(), loginForm.getPassword());
        if (user!=null){
            return new ResultEntity<>(200,"登录成功",user);
        }else {
            return new ResultEntity<>(500,"登录失败",null);
        }
    }
    @GetMapping
    @ApiOperation(value = "退出登录")
    public ResultEntity<User> add(){
        return new ResultEntity<>(200,"退出成功",null);
    }

}
