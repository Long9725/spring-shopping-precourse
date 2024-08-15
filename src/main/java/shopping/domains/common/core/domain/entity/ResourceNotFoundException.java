package shopping.domains.common.core.domain.entity;

import lombok.Getter;
import shopping.domains.common.core.domain.enums.ErrorCode;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public ResourceNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
