package com.isupov.springmvc.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
private List<Product> productRepository;

    public ProductRepository() {
        this.productRepository = new ArrayList();
    }
    public int getSize(){
       return productRepository.size();
    }
    public List<Product> getProductRepository() {
        return productRepository;
    }

    public void addProductRepository(Product product) {
        productRepository.add(product);
    }

    public Optional<Product> getProductRepositoryForID(long id) {
        for (Product o: productRepository) {
            if(o.getId() == id){
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}
