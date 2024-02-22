package dev.danieloliveira.udemycourse.model.repositories;

import dev.danieloliveira.udemycourse.model.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
