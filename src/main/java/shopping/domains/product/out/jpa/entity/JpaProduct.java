package shopping.domains.product.out.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import shopping.domains.common.out.jpa.entity.BaseJpaEntity;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.domain.entity.Product;

import java.util.UUID;

@Entity
@Table(name = "users")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JpaProduct extends BaseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private UUID id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name.value", column = @Column(name = "name")),
            @AttributeOverride(name = "price.value", column = @Column(name = "price")),
            @AttributeOverride(name = "image.downloadUrl", column = @Column(name = "image_download_url"))
    })
    private Product product;

    public JpaProduct(@NonNull final ProductDto dto) {
        super(dto);

        this.product = dto.getDeletedAt() == null ? new Product(dto) : null;
    }

    @NonNull
    public ProductDto toDto() {
        if (product == null) {
            return ProductDto.builder()
                    .id(id)
                    .createdAt(createdAt)
                    .updatedAt(updatedAt)
                    .deletedAt(deletedAt)
                    .build();
        }
        return product.toDto()
                .toBuilder()
                .id(id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .deletedAt(deletedAt)
                .build();
    }
}
