package com.rest.maven.service;

import com.rest.maven.entity.RoleEntity;
import com.rest.maven.entity.UserEntity;
import com.rest.maven.repository.RoleRepository;
import com.rest.maven.repository.UserRepository;
import com.rest.maven.requests.users.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = bCryptPasswordEncoder();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity save(UserCreateRequest userCreateRequest) {
        RoleEntity role = roleRepository.findByName("USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(role);

        UserEntity user = new UserEntity();
        user.setPasswordHash(passwordEncoder.encode(userCreateRequest.getPasswordHash()));
        user.setName(userCreateRequest.getName());
        user.setRoles(userRoles);
        System.out.println("DATA " + user);

        return userRepository.save(user);
    }

    public UserEntity perform(final UserEntity request) {
        return userRepository.save(request);
    }
}
