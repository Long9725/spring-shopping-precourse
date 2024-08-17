package shopping.domains.product.core.out;

import lombok.NonNull;
import shopping.domains.product.core.domain.dto.ProductDto;

public interface ProductOutAdapter {
    @NonNull ProductDto save(@NonNull final ProductDto dto);
}
