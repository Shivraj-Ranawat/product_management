package com.product_management.controller;

import com.product_management.model.OrderHeader;
import com.product_management.model.Product;
import com.product_management.service.OrderHeaderService;
import com.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//@Controller for html
//for  postman
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    //we are using request body for converting json data to product class object
    @PostMapping("/saveProduct")
    public ResponseEntity<?>saveProduct(@RequestBody Product product){

      return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }


    //we get  id by url it is dynamic so we use @PathVariable
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/deleteProduct{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable  Integer id){

        return new ResponseEntity<>( productService.deleteProduct(id),HttpStatus.OK);
    }
    @PostMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable Integer id){
        if(productService.updateProduct(product,id)!=null){
            return new ResponseEntity<>("Product Successfully Updated",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(productService.updateProduct(product,id),HttpStatus.CREATED);
    }




}
