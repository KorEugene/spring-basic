package ru.geekbrains.spring.lesson2.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson2.model.Product;

import java.util.List;

@Component
public interface ProductRepository {

    Product findById(Long id);

    List<Product> findAll();
}
