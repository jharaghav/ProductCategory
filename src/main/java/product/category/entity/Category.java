package product.category.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    private String categoryId;

    @OneToMany(mappedBy="category")
    private Set<Products> products;
}
