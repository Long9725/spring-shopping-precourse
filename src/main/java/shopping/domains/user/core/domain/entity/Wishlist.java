package shopping.domains.user.core.domain.entity;

import lombok.Builder;
import lombok.NonNull;
import shopping.domains.product.domain.entity.Product;

public class Wishlist {
    private User user;

    private Product product;

    @Builder(toBuilder = true)
    public Wishlist(
            @NonNull final User user,
            @NonNull final Product product
    ) {
        this.user = user;
        this.product = product;
    }
}
