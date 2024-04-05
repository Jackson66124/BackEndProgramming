package D288.Project.service;

import D288.Project.dao.CartRepository;
import D288.Project.dao.CustomerRepository;
import D288.Project.entity.Cart;
import D288.Project.entity.Cartitem;
import D288.Project.entity.Customer;
import D288.Project.entity.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
            Cart cart = purchase.getCart();
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
            Set<Cartitem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));
            cart.setStatus(StatusType.ordered);
            Customer customer = purchase.getCustomer();
            cartRepository.save(cart);
            customer.add(cart);
            return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
