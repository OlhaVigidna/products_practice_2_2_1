package ua.com.ouw.products_practice_2_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.ouw.products_practice_2_2.models.Product;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.price > :x")
    List<Product> priseHigherThen(@Param("x") int num);

    @Query("select c from Product c order by c.id desc")
    List<Product> showLast10();

    @Query("select p from Product p order by p.name asc")
    List<Product> orderByName();


    List<Product> getByPriceGreaterThan(int x);
}
