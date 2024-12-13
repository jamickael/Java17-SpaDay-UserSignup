package org.launchcode.Data;


import org.launchcode.models.User;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class UserData {

    public static final Map<Integer, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getId(), user);
    }

    public static User getById(Integer id) {
        return users.get(id);
    }

    public static Collection <User> getAll() {
        return users.values();
    }

}
