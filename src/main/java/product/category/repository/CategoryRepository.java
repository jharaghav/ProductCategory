package product.category.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import product.category.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
}
