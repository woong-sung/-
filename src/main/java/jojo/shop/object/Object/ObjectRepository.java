package jojo.shop.object.Object;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ObjectRepository extends JpaRepository<Object, Long> {
    List<Object> findAllByCategory(String category);

    List<Object> findAllByCategoryOrderByName(String category);
    @Modifying
    @Transactional
    @Query(value = "update object set ea =ea + :number where name =:name", nativeQuery = true)
    void updateEa(String name, int number);

    Optional<Object> findByName(String name);

    void deleteByName(String name);
}
