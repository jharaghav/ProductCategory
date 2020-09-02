package product.category;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import product.category.entity.Category;
import product.category.entity.Products;
import product.category.factory.CategoryFactory;
import product.category.model.CategoryA;
import product.category.repository.ProductRepository;
import product.category.services.ProductProcessingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class ProductProcessingServiceTest {

    @InjectMocks
    private ProductProcessingService productProcessingService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryFactory categoryFactory;

    @Before
    public void setUp() {
        Mockito.when(productRepository.findById("Pr01")).thenReturn(getProducts());
        Mockito.when(categoryFactory.getCategory("CATEGORYA")).thenReturn(new CategoryA());
    }

    @Test
    public void getProductsCategoryAndProductCostTest() {
        productProcessingService.getProductsCategoryAndProductCost(getProductLists());
        Assert.assertSame(productProcessingService.totalCost(getProductCost()), 100L);
        Assert.assertSame(productProcessingService.totalSalesTax(getProductCost(), getCategoryTypes()), 10L);
    }

    private List<String> getProductLists() {
        List<String> productLists = new ArrayList<>();
        productLists.add("Pr01");
        return productLists;
    }

    private List<Long> getProductCost() {
        List<Long> productCost = new ArrayList<>();
        productCost.add(100L);
        return productCost;
    }
    private List<String> getCategoryTypes() {
        List<String> categoryTypes = new ArrayList<>();
        categoryTypes.add("CATEGORYA");
        return categoryTypes;
    }

    private Optional<Products> getProducts() {
        Category categoryA = new Category();
        categoryA.setCategoryId("CATEGORYA");
        Products firstProduct = new Products();
        firstProduct.setPrice(100L);
        firstProduct.setProductId("Pr01");
        firstProduct.setCategory(categoryA);
        return Optional.ofNullable(firstProduct);
    }
}
