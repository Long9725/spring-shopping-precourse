package shopping.domains.user.core.out;

import lombok.NonNull;
import shopping.domains.user.core.domain.command.CreateWishlistCommand;
import shopping.domains.user.core.domain.dto.WishlistDto;

import java.util.UUID;

public interface WishlistOutAdapter {
    @NonNull
    WishlistDto save(@NonNull final WishlistDto dto);

    @NonNull
    boolean exist(
            @NonNull final UUID userId,
            @NonNull final UUID productId
    );

}
