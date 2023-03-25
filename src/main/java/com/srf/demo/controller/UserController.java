package com.srf.demo.controller;

import com.srf.demo.dao.UserDao;
import com.srf.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return this.userDao.getUser(id);
    }

    @GetMapping
    public List<User> getUser() {
        return this.userDao.getUser();
    }

    @PostMapping
    public User saveUser(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return this.userDao.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return this.userDao.save(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return this.userDao.delete(id);
    }
}
