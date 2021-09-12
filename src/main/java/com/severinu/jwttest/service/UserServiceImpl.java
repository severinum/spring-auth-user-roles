package com.severinu.jwttest.service;

import com.severinu.jwttest.domain.Role;
import com.severinu.jwttest.domain.User;
import com.severinu.jwttest.repository.RoleRepository;
import com.severinu.jwttest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database [{}]", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new user role the database [{}]", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Adding new role to user. [u: {}, r: {}]", user.getUsername(), role.getName());
        user.getRoles().add(role); // no need to save it as it has @Transactional annotation
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
