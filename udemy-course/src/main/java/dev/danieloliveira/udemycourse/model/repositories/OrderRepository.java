package dev.danieloliveira.udemycourse.model.repositories;

import dev.danieloliveira.udemycourse.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

}
