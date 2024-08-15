package shopping.domains.user.core.out;

import lombok.NonNull;
import shopping.domains.user.core.domain.dto.TokenDto;
import shopping.domains.user.core.domain.dto.UserDto;

import java.util.Optional;

public interface TokenOutAdapter {
    @NonNull TokenDto save(@NonNull final TokenDto dto);
}
