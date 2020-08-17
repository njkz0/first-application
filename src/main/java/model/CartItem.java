package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartItem {
    private int id;
    private int itemID;
    private int cartID;
    private int amount;

    CartItem(Cart cart, Item item){
        setItemID(item.getId());
        setCartID(cart.getId());

    }

}
