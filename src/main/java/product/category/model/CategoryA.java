package product.category.model;

public class CategoryA implements Category {

    @Override
    public Long getTaxLevyCost(Long cost) {
        return (cost * 10) / 100;
    }
}