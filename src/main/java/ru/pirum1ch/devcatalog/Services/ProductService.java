package ru.pirum1ch.devcatalog.Services;

import org.springframework.stereotype.Service;
import ru.pirum1ch.devcatalog.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();
    private long ID = 0;

    {
        productList.add(new Product(++ID, "First Product", "111", 113, "Moscow", "Pirum1ch"));
        productList.add(new Product(++ID, "Second Product", "112", 114, "Boston", "Pirum1ch"));
    }

    public List<Product> listProducts() {
        return productList;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        productList.add(product);
    }

    public void deleteProduct(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductDetails(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
