package com.springstarthere.httprequestsch8.services;

import com.springstarthere.httprequestsch8.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> findAll(){
        return products;
    }

}
