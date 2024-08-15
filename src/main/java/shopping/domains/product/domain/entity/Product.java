package shopping.domains.product.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Product {
    private Name name;

    private Price price;

    private Image image;

    @Builder(toBuilder = true)
    public Product(
            @NonNull final Name name,
            @NonNull final Price price,
            @NonNull final Image image
    ) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
