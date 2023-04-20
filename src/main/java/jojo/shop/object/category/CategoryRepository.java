package jojo.shop.object.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    void deleteByName(String name);

    Optional<Object> findByName(String name);
}
