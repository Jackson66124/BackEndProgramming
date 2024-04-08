package D288.Project.service;

import D288.Project.dao.*;
import D288.Project.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final VacationRepository vacationRepository;
    private final ExcursionRepository excursionRepository;
    private final CartitemRepository cartitemRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, VacationRepository vacationRepository, ExcursionRepository excursionRepository, CartitemRepository cartitemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.vacationRepository = vacationRepository;
        this.excursionRepository = excursionRepository;
        this.cartitemRepository = cartitemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
            try {
                Cart cart = purchase.getCart();
                String orderTrackingNumber = generateOrderTrackingNumber();
                cart.setOrderTrackingNumber(orderTrackingNumber);
                Set<Cartitem> cartItems = purchase.getCartItems();
                cartItems.forEach(item -> cart.add(item));
                cart.setStatus(StatusType.ordered);
                Customer customer = purchase.getCustomer();
//                customerRepository.save(customer);
                cartRepository.save(cart);
                customer.add(cart);
                return new PurchaseResponse(orderTrackingNumber);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cart is null or empty");
            }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
