package com.srf.demo.dao;

import com.srf.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    private Map<Integer, User> userMap = new HashMap<>();

    public User getUser(int id) {
        return this.userMap.get(id);
    }

    public List<User> getUser() {
        return new ArrayList<>(this.userMap.values());
    }

    public User save(User user) {
        User exist = this.userMap.get(user.getId());
        if (exist != null) {
            exist.setName(user.getName());
            return exist;
        }
        this.userMap.put(user.getId(), user);
        return user;
    }

    public User delete(int id) {
        return this.userMap.remove(id);
    }
}
