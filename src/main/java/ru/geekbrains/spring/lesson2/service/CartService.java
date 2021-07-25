package ru.geekbrains.spring.lesson2.service;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson2.exception.MissingProductException;
import ru.geekbrains.spring.lesson2.model.Product;

import java.util.List;

@Component
public interface CartService {

    void addProduct(Long id) throws MissingProductException;

    void removeProduct(Long id) throws MissingProductException;

    Product getProduct(Long id);

    Long getCartId();

    List<Product> getAll();
}
