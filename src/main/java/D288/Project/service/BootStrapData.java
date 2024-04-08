package D288.Project.service;

import D288.Project.dao.CountryRepository;
import D288.Project.dao.CustomerRepository;
import D288.Project.dao.DivisionRepository;
import D288.Project.entity.Customer;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository)
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

        customerRepository.save(customer1);

        customerRepository.findAll();

    }
}
