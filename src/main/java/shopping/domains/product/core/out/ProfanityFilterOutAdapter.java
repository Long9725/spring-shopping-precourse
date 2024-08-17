package shopping.domains.product.core.out;

import lombok.NonNull;

public interface ProfanityFilterOutAdapter {
    @NonNull
    boolean isCleanText(@NonNull final String value);

    @NonNull
    boolean isNotCleanText(@NonNull final String value);
}
