package product.category.repository;

import org.springframework.data.repository.CrudRepository;
import product.category.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
