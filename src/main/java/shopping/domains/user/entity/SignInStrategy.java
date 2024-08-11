package shopping.domains.user.entity;

import lombok.NonNull;

@FunctionalInterface
public interface SignInStrategy {
    boolean signIn(
            @NonNull final Email email,
            @NonNull final RawPassword rawPassword,
            @NonNull final EncryptedPassword encryptedPassword,
            @NonNull final MatchPasswordStrategy matchPasswordStrategy
    );
}
