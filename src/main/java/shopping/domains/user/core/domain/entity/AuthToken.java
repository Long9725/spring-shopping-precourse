package shopping.domains.user.core.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AuthToken {
    private String accessToken;

    private String refreshToken;

    @Builder(toBuilder = true)
    public AuthToken(
            @NonNull final String accessToken,
            @NonNull final String refreshToken
    ) {
        validate(accessToken, refreshToken);

        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    private void validate(
            @NonNull final String accessToken,
            @NonNull final String refreshToken
    ) {
        if(accessToken.equals(refreshToken)) {
            throw new IllegalArgumentException("토큰값은 같을 수 없습니다.");
        }
    }
}
