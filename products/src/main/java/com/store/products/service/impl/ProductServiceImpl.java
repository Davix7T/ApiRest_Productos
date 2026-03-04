package com.store.products.service.impl;

import com.store.products.dto.ProductRequest;
import com.store.products.dto.ProductResponse;
import com.store.products.entity.Product;
import com.store.products.exception.ResourceNotFoundException;
import com.store.products.repository.ProductRepository;
import com.store.products.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product p = new Product();
        p.setName(request.getName());
        p.setDescription(request.getDescription());
        p.setPrice(request.getPrice());
        p.setStock(request.getStock());
        return toResponse(repository.save(p));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product p = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not found"));
        return toResponse(p);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product p = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not found"));
        p.setName(request.getName());
        p.setDescription(request.getDescription());
        p.setPrice(request.getPrice());
        p.setStock(request.getStock());
        return toResponse(repository.save(p));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product " + id + " not found");
        }
        repository.deleteById(id);
    }

    private ProductResponse toResponse(Product p) {
        ProductResponse r = new ProductResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setPrice(p.getPrice());
        r.setStock(p.getStock());
        r.setCreatedAt(p.getCreatedAt());
        return r;
    }
}