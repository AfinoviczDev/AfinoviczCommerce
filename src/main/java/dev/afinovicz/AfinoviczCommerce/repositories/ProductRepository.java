package dev.afinovicz.AfinoviczCommerce.repositories;

import dev.afinovicz.AfinoviczCommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
