package product.category.repository;

import org.springframework.data.repository.CrudRepository;
import product.category.entity.Products;

public interface ProductRepository extends CrudRepository<Products, String> {

}
