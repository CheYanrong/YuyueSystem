package com.cheyanrong.controller;

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
@RequestMapping("/userController")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    @ApiOperation(value = "新增数据")
    public ResultEntity<User> add(@RequestBody @Validated(RegGroup.class) User user) {
        if (userService.addUser(user)){
            return new ResultEntity<>(200,"保存成功",user);
        }else {
            return new ResultEntity<>(500,"保存失败",null);
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation("删除数据")
    public ResultEntity delete(@PathVariable Integer id){  //@PathVariable 映射 URL 绑定的占位符
        if (userService.deleteUser(id)){
            return new ResultEntity<>(200,"删除成功",null);
        }else {
            return new ResultEntity<>(500,"删除失败",null);
        }
    }
    @PatchMapping   //我写啥你改啥
    @ApiOperation("修改数据")
    public ResultEntity<User> update(@RequestBody @Validated User user) {

        if (userService.updateUser(user)){
            return new ResultEntity<>(200,"修改成功",user);
        }else {
            return new ResultEntity<>(500,"修改失败",user);
        }
    }
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单条数据")
    @ApiImplicitParam(name = "id",value="需要查询的编号")
    public ResultEntity get(@PathVariable Integer id){  //@PathVariable 映射 URL 绑定的占位符
        return new ResultEntity<>(200,"查找成功",userService.getUserById(id));
    }
    @GetMapping
    @ApiOperation("查询所有数据")
    public ResultEntity getAll(){  //@PathVariable 映射 URL 绑定的占位符
        return new ResultEntity<>(200,"查找成功",userService.getUsers());
    }

}
