package shopping.domains.user.core.domain.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import shopping.domains.user.core.domain.dto.TokenDto;
import shopping.domains.user.core.domain.entity.AuthToken;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);

    @NonNull TokenDto entityToDto(@NonNull final AuthToken entity);

    @NonNull AuthToken dtoToEntity(@NonNull final TokenDto dto);
}
