package task.service;

import task.models.User;

public interface UserService {

    void addUser(User user);

    User updatePassword(String password , String email);

    boolean admin(User user);
}
