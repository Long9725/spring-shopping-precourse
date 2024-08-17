package shopping.domains.product.core.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Price {
    private long value;

    public Price(final long value) {
        validate(value);

        this.value = value;
    }

    private void validate(final long value) {
        if(value < 0L) {
            throw new IllegalArgumentException("상품 가격은 음수일 수 없습니다.");
        }
    }
}
