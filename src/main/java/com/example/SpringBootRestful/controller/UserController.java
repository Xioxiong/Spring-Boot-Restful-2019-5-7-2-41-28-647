package com.example.SpringBootRestful.controller;

import com.example.SpringBootRestful.entity.User;
import com.example.SpringBootRestful.exception.BusinessException;
import com.example.SpringBootRestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//ToDo:在上一行代码("")中填写合适的RestfulApi
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity getAllUser() {
        System.out.println("进入了get方法");
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/add")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println("进入了add方法");
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity updateUserById(@PathVariable int userId, @RequestBody User user) throws BusinessException {
        System.out.println("进入了update方法");
        userService.updateUserById(userId, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity deleteUserById(@PathVariable int userId) throws BusinessException {
        System.out.println("进入了delete方法");
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
