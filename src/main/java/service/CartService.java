package service;

import dao.CartDAO;
import dao.UserDAO;
import model.Cart;
import model.User;

public class CartService {

    public static Cart createNewCartForUser(User user){
        if(UserDAO.searchSuchUser(user.getLogin())!=null){
        Cart cart=new Cart(user);
        return CartDAO.saveCart(cart);}
        else return null;
    }
}
