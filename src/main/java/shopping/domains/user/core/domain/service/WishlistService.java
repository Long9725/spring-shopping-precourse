package shopping.domains.user.core.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import shopping.domains.common.core.domain.entity.AlreadyExistResourceException;
import shopping.domains.common.core.domain.entity.ResourceNotFoundException;
import shopping.domains.common.core.domain.enums.CommonErrorCode;
import shopping.domains.product.core.domain.dto.ProductDto;
import shopping.domains.product.core.out.ProductOutAdapter;
import shopping.domains.user.core.domain.command.CreateWishlistCommand;
import shopping.domains.user.core.domain.dto.UserDto;
import shopping.domains.user.core.domain.dto.WishlistDto;
import shopping.domains.user.core.in.WishlistInAdapter;
import shopping.domains.user.core.out.UserOutAdapter;
import shopping.domains.user.core.out.WishlistOutAdapter;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistService implements WishlistInAdapter {
    private final UserOutAdapter userOutAdapter;

    private final ProductOutAdapter productOutAdapter;

    private final WishlistOutAdapter wishlistOutAdapter;

    @Override
    public @NonNull WishlistDto createWishlist(@NonNull final CreateWishlistCommand command) {
        if(wishlistOutAdapter.exist(command.userId(), command.productId())) {
            throw new AlreadyExistResourceException(CommonErrorCode.ALREADY_EXIST);
        }

        final UserDto userDto = userOutAdapter.findUser(command.userId())
                .orElseThrow(() -> new ResourceNotFoundException(CommonErrorCode.NOT_EXIST));
        final ProductDto productDto = productOutAdapter.findProduct(command.productId())
                .orElseThrow(() -> new ResourceNotFoundException(CommonErrorCode.NOT_EXIST));
        final WishlistDto wishlistDto = WishlistDto.builder()
                .user(userDto)
                .product(productDto)
                .build();
        return wishlistOutAdapter.save(wishlistDto);
    }
}
