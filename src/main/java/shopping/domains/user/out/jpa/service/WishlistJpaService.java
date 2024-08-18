package shopping.domains.user.out.jpa.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopping.domains.user.core.domain.dto.WishlistDto;
import shopping.domains.user.core.out.WishlistOutAdapter;
import shopping.domains.user.out.jpa.entity.JpaWishlist;
import shopping.domains.user.out.jpa.repository.WishlistRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistJpaService implements WishlistOutAdapter {
    private final WishlistRepository wishlistRepository;

    @Override
    public @NonNull WishlistDto save(@NonNull final WishlistDto dto) {
        return wishlistRepository.save(new JpaWishlist(dto)).toDto();
    }

    @Override
    public boolean exist(
            @NonNull final UUID userId,
            @NonNull final UUID productId
    ) {
        return wishlistRepository.existsByUser_IdAndProduct_Id(userId, productId);
    }
}
