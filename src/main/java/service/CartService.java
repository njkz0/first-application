package service;

import dao.CartDAO;
import dao.UserDAO;
import exception.CantFindUserException;
import model.Cart;
import model.User;

public class CartService {


    public static Cart createNewCartIfNotExist(User user) throws CantFindUserException {
        if (UserDAO.searchSuchUser(user.getLogin()) != null) {
            if (CartDAO.searchCartByUserID(user.getId()) != null) {
                Cart cart = new Cart(user);
                return CartDAO.saveCart(cart);
            }else return null;
        } else throw new CantFindUserException("User not Exist");
    }
}
