package product.category.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    private String productId;

    @Column
    private String productName;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

}
