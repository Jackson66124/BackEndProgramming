package D288.Project.service;

import D288.Project.entity.Cart;
import D288.Project.entity.Cartitem;
import D288.Project.entity.Customer;
import D288.Project.entity.StatusType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<Cartitem> cartItems;
    private StatusType status;

}
