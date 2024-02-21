package dev.danieloliveira.udemycourse.model.config;

import dev.danieloliveira.udemycourse.model.entities.Category;
import dev.danieloliveira.udemycourse.model.entities.Order;
import dev.danieloliveira.udemycourse.model.entities.User;
import dev.danieloliveira.udemycourse.model.entities.enums.OrderStatus;
import dev.danieloliveira.udemycourse.model.repositories.CategoryRepository;
import dev.danieloliveira.udemycourse.model.repositories.OrderRepository;
import dev.danieloliveira.udemycourse.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alex Aquamarine", "alexaqua@gmail.com",
                "51988888888", "Alex@Aqua");
        User u2 = new User(null, "Bruce Brown", "brucebrown@gmail.com",
                "51977777777", "Bruce@Brown");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-09-15T09:45:34Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2020-12-07T13:35:58Z"), OrderStatus.DELIVERED, u1);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

    }
}
