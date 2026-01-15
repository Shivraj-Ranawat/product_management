package com.product_management.service;

import com.product_management.model.Product;
import com.product_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
       Product product= productRepository.findById(id).get();
       if(product!=null){
           productRepository.delete(product);
           return "Product deleted successfully";
       }
       return "Product not found";

    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id " + id));

            oldProduct.setProduct_name(product.getProduct_name());
            oldProduct.setColor(product.getColor());
            oldProduct.setSize(product.getSize());

            return productRepository.save(oldProduct);

    }

}
