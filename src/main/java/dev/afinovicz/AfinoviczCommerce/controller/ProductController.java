package dev.afinovicz.AfinoviczCommerce.controller;

import dev.afinovicz.AfinoviczCommerce.dto.ProductDTO;
import dev.afinovicz.AfinoviczCommerce.entities.Product;
import dev.afinovicz.AfinoviczCommerce.repositories.ProductRepository;
import dev.afinovicz.AfinoviczCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return dto;
    }
}
