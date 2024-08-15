package shopping.domains.user.core.out;

import lombok.NonNull;
import shopping.domains.user.core.domain.dto.UserDto;

import java.util.Optional;

public interface UserOutAdapter {
    @NonNull UserDto save(@NonNull final UserDto dto);

    @NonNull Optional<UserDto> findUser(@NonNull final String encryptedEmail);
}
