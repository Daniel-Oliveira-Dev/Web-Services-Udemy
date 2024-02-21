package dev.danieloliveira.udemycourse.model.config;

import dev.danieloliveira.udemycourse.model.entities.Order;
import dev.danieloliveira.udemycourse.model.entities.User;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alex Aquamarine", "alexaqua@gmail.com",
                "51988888888", "Alex@Aqua");
        User u2 = new User(null, "Bruce Brown", "brucebrown@gmail.com",
                "51977777777", "Bruce@Brown");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2020-09-15T09:45:34Z"), u2);
        Order o3 = new Order(null, Instant.parse("2020-12-07T13:35:58Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
