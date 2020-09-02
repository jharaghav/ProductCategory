package product.category.factory;

import org.springframework.stereotype.Component;
import product.category.model.Category;
import product.category.model.CategoryA;
import product.category.model.CategoryB;
import product.category.model.CategoryC;
import product.category.utilities.CategoryTypeConstants;

@Component
public class CategoryFactory {

    public Category getCategory(String categoryType) {
        if (categoryType.equalsIgnoreCase(CategoryTypeConstants.CATEGORYA)) {
            return new CategoryA();
        }
        if (categoryType.equalsIgnoreCase(CategoryTypeConstants.CATEGORYB)) {
            return new CategoryB();
        } else {
            return new CategoryC();
        }
    }
}