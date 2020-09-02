package product.category.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.category.entity.Products;
import product.category.factory.CategoryFactory;
import product.category.model.Category;
import product.category.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductProcessingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryFactory categoryFactory;

    public void getProductsCategoryAndProductCost(List<String> productLists) {
        List<Long> productCosts = new ArrayList<>();
        List<String> productCategories = new ArrayList<>();
        productLists.forEach(value -> {
            Optional<Products> products = productRepository.findById(value);
            if (products.isPresent()) {
                productCosts.add(products.get().getPrice());
                productCategories.add(products.get().getCategory().getCategoryId());
            }
        });
        log.info("Total cost : {}", totalCost(productCosts));
        log.info("Total Sales Tax : {}", totalSalesTax(productCosts, productCategories));
    }

    public Long totalCost(List<Long> productCosts) {
        Long sum = 0L;
        if (!productCosts.isEmpty()) {
            sum = productCosts.stream().mapToLong(Long::longValue).sum();
        }
        return sum;
    }

    public Long totalSalesTax(List<Long> productCosts, List<String> productCategories) {
        Long totalSalesTax = 0L;
        for (int i = 0; i < productCategories.size(); i++) {
            Category category = categoryFactory.getCategory(productCategories.get(i));
            totalSalesTax += category.getTaxLevyCost(productCosts.get(i));
        }
        return totalSalesTax;
    }
}
