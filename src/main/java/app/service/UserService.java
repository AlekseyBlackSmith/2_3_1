package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void removeById(int id);
    void update(int id, User user);
    User getById(int id);
    List<User> listUsers();
}
