package shopping.domains.user.core.domain.entity;

import lombok.Builder;
import lombok.NonNull;

public class User {
    private EncryptedEmail encryptedEmail;

    private EncryptedPassword encryptedPassword;

    @Builder(toBuilder = true)
    public User(
            @NonNull final EncryptedEmail encryptedEmail,
            @NonNull final EncryptedPassword encryptedPassword
    ) {
        this.encryptedEmail = encryptedEmail;
        this.encryptedPassword = encryptedPassword;
    }

    @NonNull
    public AuthToken signIn(
            @NonNull final RawPassword rawPassword,
            @NonNull final HashStrategy hashStrategy,
            @NonNull final AuthToken token
    ) {
        if(hashStrategy.match(rawPassword.getValue(), encryptedPassword.getValue())) {
            return token;
        }
        throw new IllegalArgumentException("올바르지 않은 이메일 또는 비밀번호 입니다.");
    }
}
