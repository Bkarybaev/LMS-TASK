package task.service.impl;

import task.dao.impl.UserDaoImpl;
import task.db.DataBase;
import task.exceptions.EmailException;
import task.models.User;
import task.service.UserService;
import task.valudation.RegexPattern;

public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        try {
            if (!RegexPattern.emailPattern(user.getEmail())){
                throw new EmailException("email tuura emes!!");
            }else {
                for (User u : DataBase.users) {
                     if (u.getEmail().equals(user.getEmail())){
                         throw new EmailException("myndai email bar!!");
                     }
                }
            }
            if (!RegexPattern.passwordPattern(user.getPassword())){
                throw new EmailException("password tuura emes terilgen!!");
            }
            userDao.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User updatePassword( String email,String password) {
        try {
            if (!RegexPattern.passwordPattern(password)){
                throw new EmailException("password tuura emes terildi!!");
            }
            if (!RegexPattern.emailPattern(email)){
                throw new EmailException("email tuura emes!!");
            }else {
                for (User u : DataBase.users) {
                    if (u.getEmail().equals(email)){
                        System.out.println("password Successfully ozgortuldu");
                       return userDao.updatePassword(password, email);
                    }
                }
            }
            System.out.println("email tabylganjok!!");
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean admin(User user) {
        try {
            if (!RegexPattern.passwordPattern(user.getPassword())){
                throw new EmailException("password tuura emes terilgen!!");
            }
            if (!RegexPattern.emailPattern(user.getEmail())){
                throw new EmailException("email tuura emes!!");
            }else {
                for (User u : DataBase.users) {
                    if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())){
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
