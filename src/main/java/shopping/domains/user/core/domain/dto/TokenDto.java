package shopping.domains.user.core.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import shopping.domains.common.core.domain.dto.BaseDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class TokenDto extends BaseDto {
    private final String accessToken;

    private final String refreshToken;

    @Builder(toBuilder = true)
    public TokenDto(
            final UUID id,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final LocalDateTime deletedAt,
            final String accessToken,
            final String refreshToken
    ) {
        super(id, createdAt, updatedAt, deletedAt);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
