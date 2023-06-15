package com.rest.maven.controller;

import com.rest.maven.entity.UserEntity;
import com.rest.maven.requests.users.UserCreateRequest;
import com.rest.maven.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Api(tags = "Users")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/search")
    public List<UserEntity> search() {
        return userService.findAll();
    }

    @ApiOperation("Get user")
    @GetMapping("/get")
    public Optional<UserEntity> get(Long id) {
        return userService.getById(Long.valueOf("1"));
    }

    @PostMapping("/signIn")
    public void signIn(@RequestBody @Valid UserCreateRequest body) {
        System.out.println("Body is" + body);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(@RequestBody @Valid UserCreateRequest body) {
        return new ResponseEntity<>(userService.save(body), HttpStatus.CREATED);
    }
//    public UserEntity create(@RequestBody @Valid UserCreateRequest body) {
//        System.out.println("We got entity" + body);
//        return userService.save(body);
//    }
}
