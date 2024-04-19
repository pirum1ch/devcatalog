package ru.pirum1ch.devcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pirum1ch.devcatalog.models.Image;

public interface ImagesRepository extends JpaRepository<Image, Long> {



}
