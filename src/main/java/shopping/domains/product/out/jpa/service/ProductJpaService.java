package shopping.domains.product.out.jpa.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.out.ProductOutAdapter;
import shopping.domains.product.out.jpa.entity.JpaProduct;
import shopping.domains.product.out.jpa.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductJpaService implements ProductOutAdapter {
    private final ProductRepository productRepository;

    @Override
    public @NonNull ProductDto save(@NonNull final ProductDto dto) {
        return productRepository.save(new JpaProduct(dto)).toDto();
    }
}
