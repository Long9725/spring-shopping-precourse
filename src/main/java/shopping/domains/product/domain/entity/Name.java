package shopping.domains.product.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public class Name {
    public static final int MIN_NAME_LENGTH = 1;

    public static final int MAX_NAME_LENGTH = 15;

    public static final Pattern PATTERN = Pattern.compile("^[\\p{L}\\p{N}\\s\\(\\)\\[\\]\\+\\-\\&\\/_]{"
            + MIN_NAME_LENGTH + ","
            + MAX_NAME_LENGTH + "}$");
    private String value;

    public Name(@NonNull final String value) {
        validate(value);

        this.value = value.trim();
    }

    private void validate(@NonNull final String value) {
        if (PATTERN.matcher(value.trim()).matches()) {
            return;
        }

        throw new IllegalArgumentException("올바른 상품 이름이 아닙니다.");
    }
}
