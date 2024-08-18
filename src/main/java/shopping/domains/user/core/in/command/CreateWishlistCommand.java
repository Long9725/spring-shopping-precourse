package shopping.domains.user.core.in.command;

import java.util.UUID;

public record CreateWishlistCommand (
        UUID userId,

        UUID productId
) {
}
