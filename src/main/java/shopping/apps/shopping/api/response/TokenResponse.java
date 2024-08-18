package shopping.apps.shopping.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import shopping.domains.user.core.domain.dto.TokenDto;

public record TokenResponse (
        @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", description = "액세스 토큰")
        String accessToken,

        @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", description = "리프레쉬 토큰")
        String refreshToken
) {
    public TokenResponse(@NonNull final TokenDto tokenDto) {
        this(
                tokenDto.getAccessToken(),
                tokenDto.getRefreshToken()
        );
    }
}
