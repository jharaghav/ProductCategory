package product.category.model;

public class CategoryC implements Category {

    @Override
    public Long getTaxLevyCost(Long cost) {
        return 0L;
    }
}