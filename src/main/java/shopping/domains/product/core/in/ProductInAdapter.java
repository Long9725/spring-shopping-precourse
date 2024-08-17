package shopping.domains.product.core.in;

import lombok.NonNull;
import shopping.domains.product.core.domain.command.CreateProductCommand;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.domain.entity.Product;
import shopping.domains.user.core.domain.command.SignUpCommand;
import shopping.domains.user.core.domain.dto.TokenDto;

public interface ProductInAdapter {
    @NonNull
    ProductDto createProduct(@NonNull final CreateProductCommand command);
}
