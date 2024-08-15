package shopping.domains.user.out.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.user.core.domain.dto.UserDto;
import shopping.domains.user.core.out.UserOutAdapter;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserJpaService implements UserOutAdapter {
    @Override
    public @NonNull UserDto save(@NonNull UserDto dto) {
        return null;
    }

    @Override
    public @NonNull Optional<UserDto> findUser(@NonNull String encryptedEmail) {
        return Optional.empty();
    }
}
