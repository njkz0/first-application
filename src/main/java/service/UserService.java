package service;

import dao.UserDAO;
import exception.IncorrectLogAndPassException;
import model.User;

public class UserService {
    public static User registrationNewUser(String login, String password, String firstName, String lastName) {
        if (UserDAO.searchSuchUser(login) == null) {
            User newUser = new User(0, login, password, firstName, lastName);
            return UserDAO.saveUser(newUser);
        } else {
            return null;
        }
    }

    public static int userSignIn(String login, String password) throws IncorrectLogAndPassException {
        User user = UserDAO.searchSuchUser(login);
        if (user != null && user.getPassword().equals(password)) {
            return 1;

        } else {
            throw new IncorrectLogAndPassException("Login and Password incorrect");

        }
    }
}
