package ru.geekbrains.spring.lesson2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson2.exception.MissingProductException;
import ru.geekbrains.spring.lesson2.model.Product;
import ru.geekbrains.spring.lesson2.repository.ProductRepository;
import ru.geekbrains.spring.lesson2.service.CartService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart implements CartService {

    private static Long UUID = 0L;

    private final Long id;
    private ProductRepository productRepository;
    private final List<Product> productList;

    public Cart() {
        this.id = ++UUID;
        this.productList = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Long id) throws MissingProductException {
        Product product = productRepository.findById(id);
        if (product != null) {
            productList.add(product);
        } else {
            throw new MissingProductException();
        }
    }

    @Override
    public void removeProduct(Long id) throws MissingProductException {
        int index = getProductIndexByProductId(id);
        if (index != -1) {
            productList.remove(index);
        } else {
            throw new MissingProductException();
        }
    }

    @Override
    public Product getProduct(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Long getCartId() {
        return id;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    private int getProductIndexByProductId(Long id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
