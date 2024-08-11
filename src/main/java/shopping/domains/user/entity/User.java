package shopping.domains.user.entity;

import lombok.Builder;
import lombok.NonNull;

public class User {
    private Email email;

    private EncryptedPassword encryptedPassword;

    @Builder(toBuilder = true)
    public User(
            @NonNull final Email email,
            @NonNull final EncryptedPassword encryptedPassword
    ) {
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    @NonNull
    public AuthToken signIn(
            @NonNull final RawPassword rawPassword,
            @NonNull final SignInStrategy signInStrategy,
            @NonNull final MatchPasswordStrategy matchPasswordStrategy,
            @NonNull final AuthToken token
    ) {
        if(signInStrategy.signIn(email, rawPassword, encryptedPassword, matchPasswordStrategy)) {
            return token;
        }
        throw new IllegalArgumentException("올바르지 않은 이메일 또는 비밀번호 입니다.");
    }
}
