package product.category.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import product.category.entity.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, String> {

}
