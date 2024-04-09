package D288.Project;

import D288.Project.dao.CountryRepository;
import D288.Project.dao.CustomerRepository;
import D288.Project.dao.DivisionRepository;
import D288.Project.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class D288CommandLineRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public D288CommandLineRunner(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository)
    {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer();
        customer1.setFirstName("James");
        customer1.setLastName("Black");
        customer1.setDivision(divisionRepository.findAll().get(7));
        customer1.setAddress("123 Main Street");
        customer1.setPostal_code("12345");
        customer1.setPhone("1231234567");
        customer1.setCreate_date(new Date());
        customer1.setLast_update(new Date());

        Customer customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Green");
        customer2.setDivision(divisionRepository.findAll().get(3));
        customer2.setAddress("123 Smith Street");
        customer2.setPostal_code("34728");
        customer2.setPhone("1239875463");
        customer2.setCreate_date(new Date());
        customer2.setLast_update(new Date());

        Customer customer3 = new Customer();
        customer3.setFirstName("Mike");
        customer3.setLastName("Smith");
        customer3.setDivision(divisionRepository.findAll().get(2));
        customer3.setAddress("456 Dog Road");
        customer3.setPostal_code("98574");
        customer3.setPhone("8473648976");
        customer3.setCreate_date(new Date());
        customer3.setLast_update(new Date());

        Customer customer4 = new Customer();
        customer4.setFirstName("Sam");
        customer4.setLastName("Brown");
        customer4.setDivision(divisionRepository.findAll().get(1));
        customer4.setAddress("7543 Long Road");
        customer4.setPostal_code("98463");
        customer4.setPhone("9476352409");
        customer4.setCreate_date(new Date());
        customer4.setLast_update(new Date());

        Customer customer5 = new Customer();
        customer5.setFirstName("Frank");
        customer5.setLastName("Tank");
        customer5.setDivision(divisionRepository.findAll().get(4));
        customer5.setAddress("874587 HotDog Road");
        customer5.setPostal_code("85943");
        customer5.setPhone("9574639273");
        customer5.setCreate_date(new Date());
        customer5.setLast_update(new Date());

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        customerRepository.findAll();

    }
}
