package com.product_management.service;


import com.product_management.model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProduct();
    public Product getProductById(Integer product_id);
    public String deleteProduct(Integer id);
    public Product updateProduct(Product product,Integer id);
}
