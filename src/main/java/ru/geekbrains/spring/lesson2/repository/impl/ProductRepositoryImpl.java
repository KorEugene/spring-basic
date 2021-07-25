package ru.geekbrains.spring.lesson2.repository.impl;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson2.model.Product;
import ru.geekbrains.spring.lesson2.model.ProductTitle;
import ru.geekbrains.spring.lesson2.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private static final Random RANDOM = new Random();
    private static final int PRODUCTS_COUNT = 5;

    private List<Product> products;

    @PostConstruct
    public void init() {
        ProductTitle[] productTitles = ProductTitle.values();
        products = new ArrayList<>();
        for (int i = 0; i < PRODUCTS_COUNT; i++) {
            products.add(new Product(i + 1L, productTitles[i].getTitle(), RANDOM.nextInt(1000)));
        }
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
