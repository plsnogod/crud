package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User getById(long Id);
    void updateUser(User user);
    void removeUser (long id);
}
