package ru.pirum1ch.devcatalog.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.pirum1ch.devcatalog.models.Image;
import ru.pirum1ch.devcatalog.models.Product;
import ru.pirum1ch.devcatalog.repositories.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        log.info("Возвращаем все продуты по Title");
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product, MultipartFile img1, MultipartFile img2, MultipartFile img3) throws IOException {
        Image image1, image2, image3;

        if(img1.getSize() !=0) {
            image1 = toImageEntity(img1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if(img2.getSize() !=0) {
            image2 = toImageEntity(img1);
            product.addImageToProduct(image2);
        }
        if(img3.getSize() !=0) {
            image3 = toImageEntity(img1);
            product.addImageToProduct(image3);
        }
        log.info("Saving product: title - {}, author - {}", product.getTitle(), product.getAuthor());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile img1) throws IOException {
        Image image = new Image();
        image.setName(img1.getName());
        image.setOriginalName(img1.getOriginalFilename());
        image.setContentType(img1.getContentType());
        image.setSize(img1.getSize());
        image.setByte(img1.getBytes());
        return image;
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
