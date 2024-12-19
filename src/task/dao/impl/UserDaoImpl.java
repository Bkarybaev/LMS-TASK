package task.dao.impl;

import task.dao.UserDao;
import task.db.DataBase;
import task.models.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        DataBase.users.add(user);
    }

    @Override
    public User updatePassword(String password, String email) {
        for (User u : DataBase.users) {
             if (u.getEmail().equals(email)){
                 u.setPassword(password);
                 return u;
             }
        }
        return null;
    }
}
