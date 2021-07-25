package ru.geekbrains.spring.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.lesson2.config.AppConfig;
import ru.geekbrains.spring.lesson2.repository.ProductRepository;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        System.out.println(productRepository.findById(1L));
        System.out.println(productRepository.findById(3L));
        System.out.println(productRepository.findById(5L));

        System.out.println();
        System.out.println(productRepository.findAll());

        context.close();
    }
}
