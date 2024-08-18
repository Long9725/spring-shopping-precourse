package shopping.domains.user.core.in;

import lombok.NonNull;
import shopping.domains.user.core.domain.command.CreateWishlistCommand;
import shopping.domains.user.core.domain.dto.WishlistDto;

public interface WishlistInAdapter {
    @NonNull
    WishlistDto createWishlist(@NonNull final CreateWishlistCommand command);
}
