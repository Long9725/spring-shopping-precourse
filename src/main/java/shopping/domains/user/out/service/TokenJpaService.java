package shopping.domains.user.out.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.user.core.domain.dto.TokenDto;
import shopping.domains.user.core.out.TokenOutAdapter;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenJpaService implements TokenOutAdapter {
    @Override
    public @NonNull TokenDto save(@NonNull TokenDto dto) {
        return null;
    }
}
