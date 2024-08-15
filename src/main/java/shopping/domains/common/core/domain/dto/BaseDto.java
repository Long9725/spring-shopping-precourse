package shopping.domains.common.core.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public abstract class BaseDto {
    protected final UUID id;

    protected final LocalDateTime createdAt;

    protected final LocalDateTime updatedAt;

    protected final LocalDateTime deletedAt;

    public BaseDto(
            final UUID id,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final LocalDateTime deletedAt
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
