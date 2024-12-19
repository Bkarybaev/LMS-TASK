package task.dao;

import task.models.User;

public interface UserDao {
    void save(User user);

    User updatePassword(String password, String e) ;
}
