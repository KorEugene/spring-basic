package ru.geekbrains.spring.basic.service;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.basic.model.Product;
import ru.geekbrains.spring.basic.exception.MissingProductException;

import java.util.List;

@Component
public interface CartService {

    void addProduct(Long id) throws MissingProductException;

    void removeProduct(Long id) throws MissingProductException;

    Product getProduct(Long id);

    Long getCartId();

    List<Product> getAll();
}
