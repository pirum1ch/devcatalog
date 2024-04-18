package ru.pirum1ch.devcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pirum1ch.devcatalog.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long > {

    List<Product> findByTitle(String title);
}
