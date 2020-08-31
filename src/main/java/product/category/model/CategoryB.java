package product.category.model;

public class CategoryB implements Category {

    @Override
    public Long getTaxLevyCost(Long cost) {
        return (cost * 20) / 100;
    }
}