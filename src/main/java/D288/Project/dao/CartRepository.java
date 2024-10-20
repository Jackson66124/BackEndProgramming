package D288.Project.dao;

import D288.Project.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartRepository extends JpaRepository <Cart, Long> {
}
