package ru.pirum1ch.devcatalog.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pirum1ch.devcatalog.models.Product;
import ru.pirum1ch.devcatalog.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


//    private List<Product> productList = new ArrayList<>();
//    private long ID = 0;ZZ
//
//    {
//        productList.add(new Product(++ID, "First Product", "111", 113, "Moscow", "Pirum1ch"));
//        productList.add(new Product(++ID, "Second Product", "112", 114, "Boston", "Pirum1ch"));
//    }

    public List<Product> listProducts(String title) {
        log.info("Возвращаем все продуты по Title");
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving product {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("Удаление продукта {}", id);
        productRepository.deleteById(id);
    }

    public Product getProductDetails(Long id) {
        log.info("просмотр деталей продукта {}", id);
        return productRepository.findById(id).orElse(null);
    }
}
