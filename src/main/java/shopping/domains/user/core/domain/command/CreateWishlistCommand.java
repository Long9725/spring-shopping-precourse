package shopping.domains.user.core.domain.command;

import java.util.UUID;

public record CreateWishlistCommand (
        UUID userId,

        UUID productId
) {
}
