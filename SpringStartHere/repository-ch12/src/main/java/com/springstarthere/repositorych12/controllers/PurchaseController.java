package com.springstarthere.repositorych12.controllers;


import com.springstarthere.repositorych12.model.Purchase;
import com.springstarthere.repositorych12.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return new ResponseEntity<>(purchaseRepository.findAllPurchases(), HttpStatus.OK);
    }

    @PostMapping
    public void save(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }
}
