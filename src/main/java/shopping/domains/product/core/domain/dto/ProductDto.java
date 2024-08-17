package shopping.domains.product.core.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import shopping.domains.common.core.domain.dto.BaseDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductDto extends BaseDto {
    private final UUID productId;

    private final String name;

    private final Long price;

    private final String imageUrl;

    @Builder(toBuilder = true)
    public ProductDto(
            final UUID productId,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final LocalDateTime deletedAt,
            final Long version,
            final String name,
            final Long price,
            final String imageUrl
    ) {
        super(createdAt, updatedAt, deletedAt, version);
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
