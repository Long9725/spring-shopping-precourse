package shopping.domains.product.core.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.common.core.domain.entity.ClientIllegalArgumentException;
import shopping.domains.common.core.domain.enums.CommonErrorCode;
import shopping.domains.product.core.domain.command.CreateProductCommand;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.domain.entity.Image;
import shopping.domains.product.core.domain.entity.Name;
import shopping.domains.product.core.domain.entity.Price;
import shopping.domains.product.core.domain.entity.Product;
import shopping.domains.product.core.in.ProductInAdapter;
import shopping.domains.product.core.out.ProductOutAdapter;
import shopping.domains.product.core.out.ProfanityFilterOutAdapter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductInAdapter {
    private final ProductOutAdapter productOutAdapter;

    private final ProfanityFilterOutAdapter profanityFilterOutAdapter;

    @Override
    public @NonNull ProductDto createProduct(@NonNull final CreateProductCommand command) {
        final Name name = new Name(command.name());

        if(profanityFilterOutAdapter.isNotCleanText(name.getValue())) {
            throw new ClientIllegalArgumentException(CommonErrorCode.BAD_REQUEST);
        }

        final Product product = Product.builder()
                .name(new Name(command.name()))
                .price(new Price(command.price()))
                .image(new Image(command.imageUrl()))
                .build();
        return productOutAdapter.save(product.toDto());
    }
}
