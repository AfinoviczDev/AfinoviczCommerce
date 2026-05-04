package dev.afinovicz.AfinoviczCommerce.services;

import dev.afinovicz.AfinoviczCommerce.dto.ProductDTO;
import dev.afinovicz.AfinoviczCommerce.entities.Product;
import dev.afinovicz.AfinoviczCommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO>  findAll(Pageable pageable) {
        Page<Product>  result = repository.findAll(pageable);
        //CONVERTER PRODUCT DA LISTA PARA PRODUCTDTO
        return result.map(x -> new ProductDTO(x));
    }
}
