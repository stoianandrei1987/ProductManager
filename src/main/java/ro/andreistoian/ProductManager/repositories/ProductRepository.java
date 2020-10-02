package ro.andreistoian.ProductManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.andreistoian.ProductManager.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
