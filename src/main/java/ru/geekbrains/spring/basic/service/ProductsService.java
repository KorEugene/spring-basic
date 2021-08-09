package ru.geekbrains.spring.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.basic.dao.ProductDao;
import ru.geekbrains.spring.basic.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    private ProductDao productDao;

    @Autowired
    public ProductsService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return productDao.findAll().stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public void save(Product product) {
        productDao.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void changeProductPrice(Long id, String action) {
        Product product = findById(id);
        int productCurrentPrice = product.getPrice();
        product.setPrice(action.equals("increment") ? ++productCurrentPrice : --productCurrentPrice);
        save(product);
    }
}
