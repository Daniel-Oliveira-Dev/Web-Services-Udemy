package dev.danieloliveira.udemycourse.model.config;

import dev.danieloliveira.udemycourse.model.entities.*;
import dev.danieloliveira.udemycourse.model.entities.enums.OrderStatus;
import dev.danieloliveira.udemycourse.model.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        // Adding users to test environment
        User u1 = new User(null, "Alex Aquamarine", "alexaqua@gmail.com",
                "51988888888", "Alex@Aqua");
        User u2 = new User(null, "Bruce Brown", "brucebrown@gmail.com",
                "51977777777", "Bruce@Brown");
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Adding categories to test environment
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Adding products to test environment
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        p1.getCategories().add(cat2); p2.getCategories().add(cat1); p2.getCategories().add(cat3);
        p3.getCategories().add(cat3); p4.getCategories().add(cat3); p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Adding orders to test environment
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-09-15T09:45:34Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2020-12-07T13:35:58Z"), OrderStatus.DELIVERED, u1);
        o1.setPayment(new Payment(null, Instant.parse("2019-06-20T19:57:24Z"), o1));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Setting the products for the orders
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
