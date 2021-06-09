package com.kism3t.product.controller;

import com.kism3t.product.model.Product;
import com.kism3t.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" } )
    public ResponseEntity<Collection<Product>> getProducts() {
        Collection<Product> usersList = productService.getProducts();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
/*
    @GetMapping("/{heroId}")
    public Hero getHero(@PathVariable int heroId) {
        return heroService.getHeroById(heroId);
    }

    @PutMapping()
    public void updateHero(@RequestBody(required = true) Hero hero) {
        heroService.updateHero(hero);
    }

    @PostMapping
    public Hero createHero(@RequestBody(required = true) Hero hero) {
        return heroService.createHero(hero);
    }

    @DeleteMapping("/{heroId}")
    private Hero deleteHero(@PathVariable int heroId){
        return heroService.deleteHero(heroId);
    }*/
}
