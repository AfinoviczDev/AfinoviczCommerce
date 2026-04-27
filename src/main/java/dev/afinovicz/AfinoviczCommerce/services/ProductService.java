package dev.afinovicz.AfinoviczCommerce.services;

import dev.afinovicz.AfinoviczCommerce.dto.ProductDTO;
import dev.afinovicz.AfinoviczCommerce.entities.Product;
import dev.afinovicz.AfinoviczCommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }
}
