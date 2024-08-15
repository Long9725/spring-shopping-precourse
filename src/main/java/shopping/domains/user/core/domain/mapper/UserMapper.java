package shopping.domains.user.core.domain.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import shopping.domains.user.core.domain.dto.UserDto;
import shopping.domains.user.core.domain.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @NonNull UserDto entityToDto(@NonNull final User entity);

    @NonNull User dtoToEntity(@NonNull final UserDto dto);
}
