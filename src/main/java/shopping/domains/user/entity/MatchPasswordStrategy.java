package shopping.domains.user.entity;

import lombok.NonNull;

@FunctionalInterface
public interface MatchPasswordStrategy {
    boolean encrypt(
            @NonNull final RawPassword rawPassword,
            @NonNull final EncryptedPassword encryptedPassword
    );
}
