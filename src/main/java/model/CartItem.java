package model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Builder
public class CartItem {
    private int id;
    private int itemID;
    private int cartID;
    private int amount;

    CartItem(Cart cart, Item item, int amount){
        setItemID(item.getId());
        setCartID(cart.getId());
        this.amount=amount;
    }

}
