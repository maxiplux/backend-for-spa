package io.maxiplux.spa.services;

import io.maxiplux.spa.models.Role;
import io.maxiplux.spa.models.User;

public interface UserServices {
    public void saveUser(User user);
    public io.maxiplux.spa.models.User findByUsername(String username, String password);


    Role saveRole(Role roleAdmin);
}
