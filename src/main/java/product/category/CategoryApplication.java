package product.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import product.category.services.ProductProcessingService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CategoryApplication {

    @Autowired
    private ProductProcessingService productProcessingService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CategoryApplication.class, args);
        List<String> productLists = new ArrayList<>();
        productLists.add("Pr01");
        productLists.add("Pr02");
        productLists.add("Pr03");
        ProductProcessingService productProcessingService = applicationContext.getBean(ProductProcessingService.class);
        productProcessingService.getProductsCategoryAndProductCost(productLists);
    }

}
