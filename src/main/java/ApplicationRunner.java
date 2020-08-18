import dao.CartDAO;
import dao.ItemDAO;
import dao.UserDAO;
import exception.IncorrectLogAndPassException;
import model.Cart;
import model.Item;
import model.User;
import service.UserService;

public class ApplicationRunner {
    public static void main(String[] args) {
       // User test1 = new User(1, "test1", "test1", "test1", "test1");
         //     System.out.println(UserDAO.searchSuchUser("test1").getId());
        //       Cart cart=new Cart(test1);
        //  try {
        //      System.out.println(UserService.userSignIn("test1", "test1231"));
        //  }catch (IncorrectLogAndPassException e){e.printStackTrace();}
      //  Cart testCart=new Cart(UserDAO.searchSuchUser("test1"));
      //  System.out.println(testCart.getUserID());
//
      //  CartDAO.saveCart(testCart);
       // Item test=new Item(0, "IPhone 11", 100000);
        System.out.println(ItemDAO.searchSuchItem(1).getPrice());
        ItemDAO.deleteItem(1);
    }
}
