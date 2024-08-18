package shopping.domains.product.out.jpa;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.out.ProductOutAdapter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductJpaService implements ProductOutAdapter {
    @Override
    public @NonNull ProductDto save(@NonNull final ProductDto dto) {
        return null;
    }
}
